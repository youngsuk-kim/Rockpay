package com.rockpay.domain.coupon

import com.rockpay.domain.common.Id
import com.rockpay.domain.user.Buyer

class BuyerCoupon(
    id: Id<BuyerCoupon, Long> = Id.of(),
    couponId: Id<Coupon, Long>,
    buyerId: Id<Buyer, Long>,
    isUsed: Boolean = false
) {
    var id= id
        private set

    var couponId = couponId
        private set

    var buyerId = buyerId
        private set

    var isUsed: Boolean = isUsed
        private set

    fun useCoupon() {
        if (isUsed) {
            throw IllegalStateException("이미 사용된 쿠폰입니다.")
        }

        this.isUsed = true
    }
}