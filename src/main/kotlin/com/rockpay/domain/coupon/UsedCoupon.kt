package com.rockpay.domain.coupon

import com.rockpay.domain.Id
import java.time.LocalDateTime

class UsedCoupon(
    id: Id = Id.of(),
    buyerCoupon: BuyerCoupon,
    orderId: Id,
    usedAt: LocalDateTime
) {
    var id: Id = id
        private set

    var buyerCoupon: BuyerCoupon = buyerCoupon
        private set

    var orderId: Id = orderId
        private set

    var usedAt: LocalDateTime = LocalDateTime.now()
        private set
}
