package com.rockpay.order.domain.entity

import com.rockpay.common.enums.order.OrderStatus
import com.rockpay.common.enums.order.OrderStatus.PENDING
import com.rockpay.common.vo.Id
import com.rockpay.common.vo.Price
import com.rockpay.order.domain.entity.OrderItem.Companion.sumOfPrices

class Order(
    id: Id<Order, Long> = Id.of(0),
    orderStatus: OrderStatus,
    orderItems: List<OrderItem> = emptyList()
) {
    var id = id
        private set

    var orderStatus: OrderStatus = orderStatus
        private set

    var orderItems = orderItems
        private set

    fun markAsPaid() {
        if (this.orderStatus != PENDING) {
            throw IllegalStateException("주문이 PENDING 상태일 때만 결제 완료로 변경할 수 있습니다.")
        }
        this.orderStatus = OrderStatus.PAID
    }

    fun calculateFinalPaymentAmount(couponDiscount: Price = Price.of(0), pointsToUse: Price = Price.of(0)): Price {
        val totalAmount = orderItems.sumOfPrices()
        return totalAmount - couponDiscount - pointsToUse
    }

    companion object {
        fun of(orderItems: List<OrderItem>): Order {
            return Order(orderStatus = PENDING, orderItems = orderItems)
        }
    }
}