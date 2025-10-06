package com.rockpay.storage.db.order.fixture

import com.rockpay.common.enums.order.OrderStatus
import com.rockpay.storage.db.order.entity.Order
import com.rockpay.storage.db.order.entity.OrderItem

fun order(
    orderStatus: OrderStatus = OrderStatus.PENDING,
    orderItems: List<OrderItem> = listOf(orderItem()),
): Order =
    Order(
        orderStatus = orderStatus,
        orderItems = orderItems,
    )
