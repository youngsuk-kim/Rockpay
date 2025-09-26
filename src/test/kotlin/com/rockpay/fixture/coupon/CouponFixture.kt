package com.rockpay.fixture.coupon

import com.rockpay.domain.common.Price
import com.rockpay.domain.coupon.Coupon
import com.rockpay.fixture.now
import java.time.LocalDateTime

fun coupon(
    name: String = "5000원 할인 쿠폰",
    discountAmount: Long = 5000,
    expirationDate: LocalDateTime = now.plusDays(1)
): Coupon {
    return Coupon(
        name = name,
        discountAmount = Price.of(discountAmount),
        expirationDate = expirationDate
    )
}
