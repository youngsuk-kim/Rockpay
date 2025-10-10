package com.rockpay.messaging.config

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Configuration properties for messaging
 */
@ConfigurationProperties(prefix = "rockpay.messaging")
data class MessagingProperties(
    /**
     * The type of message broker to use (kafka or rabbitmq)
     */
    val type: String = "kafka",
    /**
     * Kafka configuration properties
     */
    val kafka: KafkaProperties = KafkaProperties(),
    /**
     * RabbitMQ configuration properties
     */
    val rabbitmq: RabbitMQProperties = RabbitMQProperties(),
)

/**
 * Kafka configuration properties
 */
data class KafkaProperties(
    /**
     * Bootstrap servers
     */
    val bootstrapServers: String = "localhost:9092",
    /**
     * Consumer group ID
     */
    val consumerGroupId: String = "rockpay-consumer",
    /**
     * Auto offset reset
     */
    val autoOffsetReset: String = "earliest",
)

/**
 * RabbitMQ configuration properties
 */
data class RabbitMQProperties(
    /**
     * Host
     */
    val host: String = "localhost",
    /**
     * Port
     */
    val port: Int = 5672,
    /**
     * Username
     */
    val username: String = "guest",
    /**
     * Password
     */
    val password: String = "guest",
    /**
     * Virtual host
     */
    val virtualHost: String = "/",
)
