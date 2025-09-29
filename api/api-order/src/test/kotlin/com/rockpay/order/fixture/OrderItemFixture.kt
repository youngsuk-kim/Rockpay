package com.rockpay.order.fixture

import com.rockpay.common.enums.order.OrderItemStatus
import com.rockpay.common.vo.ExternalId
import com.rockpay.common.vo.Id
import com.rockpay.common.vo.Price
import com.rockpay.order.domain.entity.Delivery
import com.rockpay.order.domain.entity.OrderItem

fun orderItem(
    productId: ExternalId<Long> = Id.ofExternal(1L),
    quantity: Int = 1,
    price: Price = Price.of(1000),
    status: OrderItemStatus = OrderItemStatus.PAID,
    delivery: Delivery = Delivery.of()
): OrderItem {
    return OrderItem.of(
        productId = productId,
        quantity = quantity,
        price = price,
        status = status,
        delivery = delivery
    )
}
