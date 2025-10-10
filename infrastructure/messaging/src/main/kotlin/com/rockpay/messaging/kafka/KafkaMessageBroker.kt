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
 * Kafka implementation of the MessageBroker interface
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

        // Add headers to the record
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

        // Check if we already have a container for this topic and group
        if (containers.containsKey(containerKey)) {
            return
        }

        // Configure container properties with groupId
        val containerProperties = ContainerProperties(topic)

        // Create and configure the container with the consumer factory and properties
        val container = KafkaMessageListenerContainer(kafkaConsumerFactory, containerProperties)

        // Set the group ID on the container's consumer properties
        container.containerProperties.setGroupId(groupId)

        // Set up the message listener with explicit type parameter
        container.setupMessageListener(
            MessageListener<String, String> { record ->
                val headers = mutableMapOf<String, Any>()
                record.headers().forEach { header ->
                    headers[header.key()] = String(header.value())
                }

                callback(record.value(), headers)
            },
        )

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
