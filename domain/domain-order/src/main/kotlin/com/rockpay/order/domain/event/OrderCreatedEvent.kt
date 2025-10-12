package com.rockpay.order.domain.event

import com.rockpay.order.domain.entity.Order
import com.rockpay.order.domain.entity.OrderItem
import java.time.LocalDateTime

data class OrderCreatedEvent(
    val orderId: Long,
    val orderItems: List<OrderItemEvent>,
    val createdAt: LocalDateTime = LocalDateTime.now(),
) {
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
