package com.rockpay.core.domain.entity.coupon

import com.rockpay.support.domain.Price
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "coupon")
class Coupon(
    id: Long = 0L,
    name: String,
    discountAmount: Price,
    expirationDate: LocalDateTime,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = id
        private set

    @Column(name = "name")
    var name: String = name
        private set

    @Column(name = "discount_amount")
    var discountAmount: Price = discountAmount
        private set

    @Column(name = "expiration_date")
    var expirationDate: LocalDateTime = expirationDate
        private set

    fun isExpired(now: LocalDateTime): Boolean = now.isAfter(expirationDate)
}
