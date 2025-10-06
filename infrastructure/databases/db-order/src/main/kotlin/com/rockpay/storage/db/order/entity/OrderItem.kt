package com.rockpay.storage.db.order.entity

import com.rockpay.common.enums.order.OrderItemStatus
import com.rockpay.common.vo.ExternalId
import com.rockpay.common.vo.Id
import com.rockpay.common.vo.Price

class OrderItem(
    id: Id<OrderItem, Long> = Id.of(0),
    val productId: ExternalId<Long>,
    val quantity: Int,
    val price: Price,
    var status: OrderItemStatus,
    val delivery: Delivery,
) {
    var id = id
        private set

    fun getTotalPrice(): Price = price * quantity

    fun markAsReturnRequest() {
        this.status = OrderItemStatus.RETURN_REQUEST
    }

    fun ship() {
        require(this.status == OrderItemStatus.PAID) { "결제가 완료 되어야 배송이 가능 합니다" }

        this.delivery.markAsShipped()
    }

    companion object {
        fun of(
            productId: ExternalId<Long>,
            quantity: Int,
            price: Price,
            status: OrderItemStatus,
            delivery: Delivery,
        ): OrderItem =
            OrderItem(
                productId = productId,
                quantity = quantity,
                price = price,
                status = status,
                delivery = delivery,
            )

        fun List<OrderItem>.sumOfPrices(): Price = this.fold(Price.of()) { acc, orderItem -> acc + orderItem.getTotalPrice() }
    }
}
