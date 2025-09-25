package com.rockpay.domain.coupon

import com.rockpay.domain.Id

class BuyerCoupon(
    id: Id = Id.of(),
    couponId: Id,
    buyerId: Id,
    isUsed: Boolean = false
) {
    var id: Id = id
        private set

    var couponId: Id = couponId
        private set

    var buyerId: Id = buyerId
        private set

    var isUsed: Boolean = isUsed
        private set

    fun useCoupon(): BuyerCoupon {
        if (isUsed) {
            throw IllegalStateException("이미 사용된 쿠폰 입니다.")
        }
        return BuyerCoupon(id = this.id, couponId = this.couponId, buyerId = this.buyerId, isUsed = true)
    }
}