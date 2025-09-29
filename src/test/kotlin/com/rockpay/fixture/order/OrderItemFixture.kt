package com.rockpay.fixture.order

import com.rockpay.domain.order.Delivery
import com.rockpay.domain.order.OrderItem
import com.rockpay.domain.order.OrderItemStatus
import com.rockpay.domain.product.Product
import com.rockpay.fixture.product.product

fun orderItem(
    product: Product = product(),
    quantity: Int = 1,
    status: OrderItemStatus = OrderItemStatus.PAID,
    delivery: Delivery = Delivery.of()
): OrderItem {
    return OrderItem.of(
        product = product,
        quantity = quantity,
        status = status,
        delivery = delivery
    )
}
