package com.rockpay.messaging.rabbitmq

import com.fasterxml.jackson.databind.ObjectMapper
import com.rockpay.messaging.MessageBroker
import org.springframework.amqp.core.MessageProperties
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import java.util.concurrent.ConcurrentHashMap

/**
 * MessageBroker 인터페이스의 RabbitMQ 구현체
 */
class RabbitMQMessageBroker(
    private val rabbitTemplate: RabbitTemplate,
    private val connectionFactory: ConnectionFactory,
    private val objectMapper: ObjectMapper,
) : MessageBroker {
    private val containers = ConcurrentHashMap<String, SimpleMessageListenerContainer>()
    private val messageConverter = Jackson2JsonMessageConverter()

    init {
        rabbitTemplate.messageConverter = messageConverter
    }

    override fun publish(
        topic: String,
        message: String,
        headers: Map<String, Any>,
    ) {
        val messageProperties = MessageProperties()

        // 메시지 속성에 헤더 추가
        headers.forEach { (key, value) ->
            messageProperties.setHeader(key, value)
        }

        // 컨텐츠와 속성을 포함한 메시지 생성
        val amqpMessage = messageConverter.toMessage(message, messageProperties)

        // 라우팅 키(토픽)를 사용하여 익스체인지로 메시지 전송
        rabbitTemplate.send(topic, "", amqpMessage)
    }

    override fun publish(
        topic: String,
        message: Any,
        headers: Map<String, Any>,
    ) {
        val messageJson = objectMapper.writeValueAsString(message)
        publish(topic, messageJson, headers)
    }

    override fun subscribe(
        topic: String,
        groupId: String,
        callback: (String, Map<String, Any>) -> Unit,
    ) {
        val containerKey = "$topic-$groupId"

        // 이미 해당 토픽과 그룹에 대한 컨테이너가 있는지 확인
        if (containers.containsKey(containerKey)) {
            return
        }

        // 콜백을 호출할 메시지 리스너 생성
        val messageListener =
            object : MessageListenerAdapter() {
                override fun onMessage(message: org.springframework.amqp.core.Message) {
                    val headers = mutableMapOf<String, Any>()

                    // 메시지 속성에서 헤더 추출
                    message.messageProperties.headers.forEach { (key, value) ->
                        if (value != null) {
                            headers[key] = value
                        }
                    }

                    // 메시지 본문을 문자열로 변환
                    val messageBody = String(message.body)

                    // 메시지 본문과 헤더로 콜백 호출
                    callback(messageBody, headers)
                }
            }

        // 컨테이너 생성 및 설정
        val container = SimpleMessageListenerContainer(connectionFactory)
        container.setQueueNames(groupId)
        container.setMessageListener(messageListener)

        // 컨테이너 시작 및 저장
        container.start()
        containers[containerKey] = container
    }

    override fun unsubscribe(
        topic: String,
        groupId: String,
    ) {
        val containerKey = "$topic-$groupId"
        val container = containers[containerKey]

        if (container != null) {
            container.stop()
            containers.remove(containerKey)
        }
    }
}
