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

    fun markAsReturnRequest() {
        this.status = RETURN_REQUEST
    }

    fun ship() {
        require(this.status == PAID) { "결제가 완료 되어야 배송이 가능 합니다" }

        this.delivery.markAsShipped()
    }

    companion object {
        fun of(product: Product, quantity: Int, status: OrderItemStatus, delivery: Delivery): OrderItem {
            return OrderItem(
                productId = product.id,
                quantity = quantity,
                price = product.calculateSalePrice() * quantity,
                status = status,
                delivery = delivery
            )
        }

        fun List<OrderItem>.sumOfPrices(): Price {
            return this.fold(Price.of()) { acc, orderItem -> acc + orderItem.price }
        }
    }
}

