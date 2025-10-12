package com.rockpay.messaging.adapter

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import com.rockpay.messaging.MessageBroker as MessagingMessageBroker
import com.rockpay.support.domain.MessageBroker as SupportMessageBroker

/**
 * 두 개의 MessageBroker 인터페이스 간 어댑터 설정 클래스
 */
@Configuration
class MessageBrokerAdapter {
    /**
     * support domain의 MessageBroker 인터페이스를 구현하고
     * messaging 모듈의 MessageBroker 구현체에 위임하는 빈을 생성합니다.
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
