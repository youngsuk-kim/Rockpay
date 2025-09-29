package com.rockpay.order.fixture

import com.rockpay.common.enums.order.OrderStatus
import com.rockpay.order.domain.entity.Order
import com.rockpay.order.domain.entity.OrderItem

fun order(
    orderStatus: OrderStatus = OrderStatus.PENDING,
    orderItems: List<OrderItem> = listOf(orderItem())
): Order {
    return Order(
        orderStatus = orderStatus,
        orderItems = orderItems
    )
}
