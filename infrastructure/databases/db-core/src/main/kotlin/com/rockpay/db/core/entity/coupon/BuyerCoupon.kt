package com.rockpay.db.core.entity.coupon

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "buyer_coupon")
class BuyerCoupon(
    id: Long = 0L,
    couponId: Long = 0L,
    buyerId: Long = 0L,
    isUsed: Boolean = false,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = id
        private set

    @Column(name = "coupon_id")
    var couponId: Long = couponId
        private set

    @Column(name = "buyer_id")
    var buyerId: Long = buyerId
        private set

    @Column(name = "is_used")
    var isUsed: Boolean = isUsed
        private set

    fun useCoupon() {
        if (isUsed) {
            throw IllegalStateException("이미 사용된 쿠폰 입니다.")
        }

        this.isUsed = true
    }
}
