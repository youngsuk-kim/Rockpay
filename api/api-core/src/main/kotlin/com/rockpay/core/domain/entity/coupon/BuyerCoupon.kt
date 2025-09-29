package com.rockpay.core.domain.entity.coupon

import com.rockpay.common.vo.Id
import com.rockpay.core.domain.entity.user.Buyer

class BuyerCoupon(
    val id: Id<BuyerCoupon, Long> = Id.of(0L),
    val couponId: Id<Coupon, Long>,
    val buyerId: Id<Buyer, Long>,
    var isUsed: Boolean = false,
) {
    fun useCoupon() {
        if (isUsed) {
            throw IllegalStateException("이미 사용된 쿠폰 입니다.")
        }

        this.isUsed = true
    }
}
