package com.rockpay.order.domain.fixture

import com.rockpay.order.domain.entity.Delivery
import com.rockpay.order.domain.entity.OrderItem
import com.rockpay.order.domain.entity.OrderItemStatus
import com.rockpay.support.domain.Price

fun orderItem(
    productId: Long = 1L,
    quantity: Int = 1,
    price: Price = Price.of(1000),
    status: OrderItemStatus = OrderItemStatus.PAID,
    delivery: Delivery = Delivery.of(),
): OrderItem =
    OrderItem.of(
        productId = productId,
        quantity = quantity,
        price = price,
        status = status,
        delivery = delivery,
    )
