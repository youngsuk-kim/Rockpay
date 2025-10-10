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
 * RabbitMQ implementation of the MessageBroker interface
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

        // Add headers to the message properties
        headers.forEach { (key, value) ->
            messageProperties.setHeader(key, value)
        }

        // Create a message with the content and properties
        val amqpMessage = messageConverter.toMessage(message, messageProperties)

        // Send the message to the exchange with the routing key (topic)
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

        // Check if we already have a container for this topic and group
        if (containers.containsKey(containerKey)) {
            return
        }

        // Create a message listener that will invoke our callback
        val messageListener =
            object : MessageListenerAdapter() {
                override fun onMessage(message: org.springframework.amqp.core.Message) {
                    val headers = mutableMapOf<String, Any>()

                    // Extract headers from the message properties
                    message.messageProperties.headers.forEach { (key, value) ->
                        if (value != null) {
                            headers[key] = value
                        }
                    }

                    // Convert the message body to a string
                    val messageBody = String(message.body)

                    // Invoke the callback with the message body and headers
                    callback(messageBody, headers)
                }
            }

        // Create and configure the container
        val container = SimpleMessageListenerContainer(connectionFactory)
        container.setQueueNames(groupId)
        container.setMessageListener(messageListener)

        // Start the container and store it
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
