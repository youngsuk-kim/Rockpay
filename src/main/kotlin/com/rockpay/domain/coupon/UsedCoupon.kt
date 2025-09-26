package com.rockpay.domain.coupon

import com.rockpay.domain.Id
import com.rockpay.domain.order.Order
import java.time.LocalDateTime

class UsedCoupon(
    id: Id<UsedCoupon> = Id.of(),
    buyerCoupon: BuyerCoupon,
    orderId: Id<Order>,
    usedAt: LocalDateTime
) {
    var id = id
        private set

    var buyerCoupon: BuyerCoupon = buyerCoupon
        private set

    var orderId = orderId
        private set

    var usedAt: LocalDateTime = LocalDateTime.now()
        private set
}
