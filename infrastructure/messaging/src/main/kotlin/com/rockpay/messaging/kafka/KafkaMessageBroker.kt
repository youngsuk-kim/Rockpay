package com.rockpay.messaging.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import com.rockpay.messaging.MessageBroker
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.header.internals.RecordHeader
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.listener.ContainerProperties
import org.springframework.kafka.listener.KafkaMessageListenerContainer
import org.springframework.kafka.listener.MessageListener
import java.util.concurrent.ConcurrentHashMap

/**
 * MessageBroker 인터페이스의 Kafka 구현체
 */
class KafkaMessageBroker(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val kafkaConsumerFactory: ConsumerFactory<String, String>,
    private val objectMapper: ObjectMapper,
) : MessageBroker {
    private val containers = ConcurrentHashMap<String, KafkaMessageListenerContainer<String, String>>()

    override fun publish(
        topic: String,
        message: String,
        headers: Map<String, Any>,
    ) {
        val record = ProducerRecord<String, String>(topic, message)

        // 레코드에 헤더 추가
        headers.forEach { (key, value) ->
            record.headers().add(RecordHeader(key, value.toString().toByteArray()))
        }

        kafkaTemplate.send(record)
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

        // groupId로 컨테이너 속성 설정
        val containerProperties = ContainerProperties(topic)

        // 컨슈머 팩토리와 속성으로 컨테이너 생성 및 설정
        val container = KafkaMessageListenerContainer(kafkaConsumerFactory, containerProperties)

        // 컨테이너의 컨슈머 속성에 그룹 ID 설정
        container.containerProperties.setGroupId(groupId)

        // 명시적인 타입 파라미터로 메시지 리스너 설정
        container.setupMessageListener(
            MessageListener<String, String> { record ->
                val headers = mutableMapOf<String, Any>()
                record.headers().forEach { header ->
                    headers[header.key()] = String(header.value())
                }

                callback(record.value(), headers)
            },
        )

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
