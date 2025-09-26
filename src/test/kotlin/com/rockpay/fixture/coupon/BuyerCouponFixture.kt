package com.rockpay.fixture.coupon

import com.rockpay.domain.common.Id
import com.rockpay.domain.coupon.BuyerCoupon
import com.rockpay.domain.coupon.Coupon
import com.rockpay.domain.user.Buyer

fun buyerCoupon(couponId: Id<Coupon> = Id.of(), buyerId: Id<Buyer> = Id.of(), isUsed: Boolean = false): BuyerCoupon {
    return BuyerCoupon(
        couponId = couponId,
        buyerId = buyerId,
        isUsed = isUsed
    )
}
