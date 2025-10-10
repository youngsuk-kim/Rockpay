package com.rockpay.support.domain

/**
 * Common interface for message brokers (Kafka, RabbitMQ, etc.)
 * This interface defines the contract for sending and receiving messages
 * in an event-driven architecture.
 */
interface MessageBroker {
    /**
     * Publishes a message to the specified topic/exchange
     *
     * @param topic The topic or exchange to publish the message to
     * @param message The message to publish
     * @param headers Optional headers to include with the message
     */
    fun publish(
        topic: String,
        message: String,
        headers: Map<String, Any> = emptyMap(),
    )

    /**
     * Publishes a message to the specified topic/exchange
     *
     * @param topic The topic or exchange to publish the message to
     * @param message The message to publish as an object (will be serialized to JSON)
     * @param headers Optional headers to include with the message
     */
    fun publish(
        topic: String,
        message: Any,
        headers: Map<String, Any> = emptyMap(),
    )

    /**
     * Subscribes to a topic/exchange to receive messages
     *
     * @param topic The topic or exchange to subscribe to
     * @param groupId The consumer group ID (for Kafka) or queue name (for RabbitMQ)
     * @param callback The callback function to invoke when a message is received
     */
    fun subscribe(
        topic: String,
        groupId: String,
        callback: (String, Map<String, Any>) -> Unit,
    )

    /**
     * Unsubscribes from a topic/exchange
     *
     * @param topic The topic or exchange to unsubscribe from
     * @param groupId The consumer group ID (for Kafka) or queue name (for RabbitMQ)
     */
    fun unsubscribe(
        topic: String,
        groupId: String,
    )
}
