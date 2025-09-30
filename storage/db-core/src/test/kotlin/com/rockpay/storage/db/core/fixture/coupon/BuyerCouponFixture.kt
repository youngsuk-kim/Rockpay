package com.rockpay.storage.db.core.fixture.coupon

import com.rockpay.common.vo.Id
import com.rockpay.storage.db.core.entity.coupon.BuyerCoupon
import com.rockpay.storage.db.core.entity.coupon.Coupon
import com.rockpay.storage.db.core.entity.user.Buyer

fun buyerCoupon(
    couponId: Id<Coupon, Long> = Id.of(0),
    buyerId: Id<Buyer, Long> = Id.of(0),
    isUsed: Boolean = false,
): BuyerCoupon =
    BuyerCoupon(
        couponId = couponId,
        buyerId = buyerId,
        isUsed = isUsed,
    )
