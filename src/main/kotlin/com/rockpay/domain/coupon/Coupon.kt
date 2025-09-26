package com.rockpay.domain.coupon

import com.rockpay.domain.Id
import com.rockpay.domain.Price
import java.time.LocalDateTime

class Coupon(
    id: Id<Coupon> = Id.of(),
    name: String,
    discountAmount: Price,
    expirationDate: LocalDateTime
) {
    var id = id
        private set

    var name: String = name
        private set

    var discountAmount: Price = discountAmount
        private set

    var expirationDate: LocalDateTime = expirationDate
        private set

    fun isExpired(now: LocalDateTime): Boolean {
        return now.isAfter(expirationDate)
    }
}