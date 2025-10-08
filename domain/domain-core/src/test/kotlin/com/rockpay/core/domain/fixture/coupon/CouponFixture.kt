package com.rockpay.core.domain.fixture.coupon

import com.rockpay.core.domain.entity.coupon.Coupon
import com.rockpay.core.domain.fixture.now
import com.rockpay.support.domain.Price
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
