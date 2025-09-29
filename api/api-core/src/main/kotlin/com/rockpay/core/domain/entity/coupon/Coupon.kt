package com.rockpay.core.domain.entity.coupon

import com.rockpay.common.vo.Id
import com.rockpay.common.vo.Price
import java.time.LocalDateTime

class Coupon(
    val id: Id<Coupon, Long> = Id.of(0L),
    val name: String,
    val discountAmount: Price,
    val expirationDate: LocalDateTime
) {
    fun isExpired(now: LocalDateTime): Boolean {
        return now.isAfter(expirationDate)
    }
}
