package com.rockpay.domain.order

import com.rockpay.domain.common.Id
import com.rockpay.domain.common.Price
import com.rockpay.domain.coupon.Coupon
import com.rockpay.domain.order.OrderItem.Companion.sumOfPrices
import com.rockpay.domain.order.OrderStatus.PENDING
import com.rockpay.domain.point.PointBalance

class Order(
    id: Id<Order, Long> = Id(0L),
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
        if (this.orderStatus != OrderStatus.PENDING) {
            throw IllegalStateException("주문이 PENDING 상태일 때만 결제 완료로 변경할 수 있습니다.")
        }
        this.orderStatus = OrderStatus.PAID
    }

    fun calculateFinalPaymentAmount(coupon: Coupon? = null, pointsToUse: PointBalance? = null): Price {
        var totalPrice = orderItems.sumOfPrices()

        if (coupon != null) {
            totalPrice -= coupon.discountAmount
        }

        if (pointsToUse != null) {
            totalPrice -= pointsToUse
        }

        return totalPrice
    }

    companion object {
        fun of(orderItems: List<OrderItem>): Order {
            return Order(orderStatus = PENDING, orderItems = orderItems)
        }
    }
}
