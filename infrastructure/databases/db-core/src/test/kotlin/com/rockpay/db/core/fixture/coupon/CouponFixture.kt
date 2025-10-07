package com.rockpay.db.core.fixture.coupon

import com.rockpay.common.vo.Price
import com.rockpay.db.core.entity.coupon.Coupon
import com.rockpay.db.core.fixture.now
import java.time.LocalDateTime

fun coupon(
    name: String = "5000원 할인 쿠폰",
    discountAmount: Long = 5000,
    expirationDate: LocalDateTime = now.plusDays(1),
): Coupon =
    Coupon(
        name = name,
        discountAmount = Price.of(discountAmount),
        expirationDate = expirationDate,
    )
