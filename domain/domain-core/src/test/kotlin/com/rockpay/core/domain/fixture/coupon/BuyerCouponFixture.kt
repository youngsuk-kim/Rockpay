package com.rockpay.core.domain.fixture.coupon

import com.rockpay.core.domain.entity.coupon.BuyerCoupon

fun buyerCoupon(
    couponId: Long = 0L,
    buyerId: Long = 0L,
    isUsed: Boolean = false,
): BuyerCoupon =
    BuyerCoupon(
        couponId = couponId,
        buyerId = buyerId,
        isUsed = isUsed,
    )
