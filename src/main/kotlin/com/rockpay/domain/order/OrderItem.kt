package com.rockpay.domain.order

import com.rockpay.domain.Id
import com.rockpay.domain.Price
import com.rockpay.domain.order.OrderItemStatus.PAID
import com.rockpay.domain.order.OrderItemStatus.RETURN_REQUEST
import com.rockpay.domain.product.Product

class OrderItem(
    id: Id<OrderItem> = Id.of(),
    productId: Id<Product>,
    quantity: Int,
    price: Price,
    status: OrderItemStatus,
    delivery: Delivery,
) {
    var id = id
        private set

    var productId = productId
        private set

    var quantity: Int = quantity
        private set

    var price: Price = price
        private set

    var status: OrderItemStatus = status
        private set

    var delivery: Delivery = delivery
        private set

    private fun copy(
        status: OrderItemStatus,
        delivery: Delivery,
    ): OrderItem {
        return OrderItem(
            id = id,
            productId = productId,
            quantity = quantity,
            price = price,
            status = status,
            delivery = delivery
        )
    }

    fun returnRequest(): OrderItem {
        return copy(status = RETURN_REQUEST, delivery = this.delivery)
    }

    fun shipped(): OrderItem {
        return copy(status = PAID, delivery = this.delivery.shippedDelivery())
    }
}