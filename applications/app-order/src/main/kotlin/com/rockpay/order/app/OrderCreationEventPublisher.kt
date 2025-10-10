package com.rockpay.order.app

import com.rockpay.order.domain.entity.Order
import com.rockpay.order.domain.event.OrderCreatedEvent
import com.rockpay.support.domain.MessageBroker
import org.springframework.stereotype.Component
import org.springframework.transaction.support.TransactionSynchronization
import org.springframework.transaction.support.TransactionSynchronizationManager

@Component
class OrderCreationEventPublisher(
    private val messageBroker: MessageBroker,
) {
    fun publish(order: Order) {
        TransactionSynchronizationManager.registerSynchronization(
            object : TransactionSynchronization {
                override fun afterCommit() {
                    val orderCreatedEvent = OrderCreatedEvent.from(order)
                    messageBroker.publish("order.created", orderCreatedEvent)
                }
            },
        )
    }
}
