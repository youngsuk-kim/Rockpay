package com.rockpay.order.domain.fixture

import com.rockpay.order.domain.entity.Order
import com.rockpay.order.domain.entity.OrderItem
import com.rockpay.order.domain.entity.OrderStatus

fun order(
    orderStatus: OrderStatus = OrderStatus.PENDING,
    orderItems: MutableList<OrderItem> = mutableListOf(orderItem()),
): Order =
    Order(
        orderStatus = orderStatus,
        orderItems = orderItems,
    )
