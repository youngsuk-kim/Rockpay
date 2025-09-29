package com.rockpay.core.fixture.coupon

import com.rockpay.common.vo.Id
import com.rockpay.core.domain.entity.coupon.BuyerCoupon
import com.rockpay.core.domain.entity.coupon.Coupon
import com.rockpay.core.domain.entity.user.Buyer

fun buyerCoupon(couponId: Id<Coupon, Long> = Id.of(0), buyerId: Id<Buyer, Long> = Id.of(0), isUsed: Boolean = false): BuyerCoupon {
    return BuyerCoupon(
        couponId = couponId,
        buyerId = buyerId,
        isUsed = isUsed
    )
}
