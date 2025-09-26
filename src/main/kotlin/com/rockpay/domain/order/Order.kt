package com.rockpay.domain.order

import com.rockpay.domain.Id
import com.rockpay.domain.order.OrderStatus.PENDING

class Order(
    id: Id<Order> = Id.of(),
    orderStatus: OrderStatus,
    orderItems: List<OrderItem> = emptyList()
) {
    var id = id
        private set

    var orderStatus: OrderStatus = orderStatus
        private set

    var orderItems = orderItems
        private set

    fun changeOrderStatus(orderStatus: OrderStatus) {
        this.orderStatus = orderStatus
    }

    fun pendingOrder(): Order {
        return Order(this.id, PENDING, this.orderItems)
    }

    companion object {
        fun createPendingOrder(orderItems: List<OrderItem>): Order {
            return Order(orderStatus = PENDING, orderItems = orderItems)
        }
    }
}