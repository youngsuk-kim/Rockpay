package com.rockpay.db.core.entity.point

import com.rockpay.common.vo.PointBalance
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "point")
class Point(
    id: Long = 0L,
    buyerId: Long = 0L,
    balance: PointBalance = PointBalance.zero(),
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = id
        private set

    @Column(name = "buyer_id")
    var buyerId: Long = buyerId
        private set

    @Column(name = "balance")
    var balance: PointBalance = balance
        private set

    fun addPoints(amount: PointBalance) {
        require(amount.value > BigDecimal.ZERO) { "추가할 포인트는 0보다 커야 합니다." }

        this.balance += amount
    }

    fun usePoints(amount: PointBalance) {
        require(amount.value > BigDecimal.ZERO) { "사용할 포인트는 0보다 커야 합니다." }
        require(this.balance >= amount) { "잔액이 부족합니다." }

        this.balance -= amount
    }
}
