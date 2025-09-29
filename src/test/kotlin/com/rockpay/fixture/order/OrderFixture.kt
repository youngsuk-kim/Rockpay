package com.rockpay.fixture.order

import com.rockpay.domain.order.Order
import com.rockpay.domain.order.OrderItem
import com.rockpay.domain.order.OrderStatus

fun order(
    orderStatus: OrderStatus = OrderStatus.PENDING,
    orderItems: List<OrderItem> = listOf(orderItem())
): Order {
    return Order(
        orderStatus = orderStatus,
        orderItems = orderItems
    )
}
