package com.rockpay.messaging.adapter

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import com.rockpay.messaging.MessageBroker as MessagingMessageBroker
import com.rockpay.support.domain.MessageBroker as SupportMessageBroker

/**
 * Configuration class that adapts between the two MessageBroker interfaces
 */
@Configuration
class MessageBrokerAdapter {
    /**
     * Creates a bean that implements the support domain's MessageBroker interface
     * and delegates to the messaging module's MessageBroker implementation
     */
    @Bean
    fun supportMessageBroker(messagingMessageBroker: MessagingMessageBroker): SupportMessageBroker =
        object : SupportMessageBroker {
            override fun publish(
                topic: String,
                message: String,
                headers: Map<String, Any>,
            ) {
                messagingMessageBroker.publish(topic, message, headers)
            }

            override fun publish(
                topic: String,
                message: Any,
                headers: Map<String, Any>,
            ) {
                messagingMessageBroker.publish(topic, message, headers)
            }

            override fun subscribe(
                topic: String,
                groupId: String,
                callback: (String, Map<String, Any>) -> Unit,
            ) {
                messagingMessageBroker.subscribe(topic, groupId, callback)
            }

            override fun unsubscribe(
                topic: String,
                groupId: String,
            ) {
                messagingMessageBroker.unsubscribe(topic, groupId)
            }
        }
}
