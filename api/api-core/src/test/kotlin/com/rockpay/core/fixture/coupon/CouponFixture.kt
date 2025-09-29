package com.rockpay.core.fixture.coupon

import com.rockpay.common.vo.Price
import com.rockpay.core.domain.entity.coupon.Coupon
import com.rockpay.core.fixture.now
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
