package com.rockpay.order.domain.event

import com.rockpay.order.domain.entity.Order
import com.rockpay.order.domain.entity.OrderItem
import java.time.LocalDateTime

/**
 * Domain event that represents an order being created.
 * This event is published after the order is successfully saved to the database.
 */
data class OrderCreatedEvent(
    val orderId: Long,
    val orderItems: List<OrderItemEvent>,
    val createdAt: LocalDateTime = LocalDateTime.now(),
) {
    /**
     * Data class representing order item information in the event.
     */
    data class OrderItemEvent(
        val productId: Long,
        val quantity: Int,
        val price: Long,
    ) {
        companion object {
            fun from(orderItem: OrderItem): OrderItemEvent =
                OrderItemEvent(
                    productId = orderItem.productId,
                    quantity = orderItem.quantity,
                    price = orderItem.price.value.longValueExact(),
                )
        }
    }

    companion object {
        fun from(order: Order): OrderCreatedEvent =
            OrderCreatedEvent(
                orderId = order.id,
                orderItems = order.orderItems.map { OrderItemEvent.from(it) },
            )
    }
}
