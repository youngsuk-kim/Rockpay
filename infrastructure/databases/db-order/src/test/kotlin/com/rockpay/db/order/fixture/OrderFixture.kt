package com.rockpay.db.order.fixture

import com.rockpay.common.enums.order.OrderStatus
import com.rockpay.db.order.entity.Order
import com.rockpay.db.order.entity.OrderItem

fun order(
    orderStatus: OrderStatus = OrderStatus.PENDING,
    orderItems: List<OrderItem> = listOf(orderItem()),
): Order =
    Order(
        orderStatus = orderStatus,
        orderItems = orderItems,
    )
