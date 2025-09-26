package com.rockpay.domain.point

import com.rockpay.domain.Id
import java.math.BigDecimal

import com.rockpay.domain.user.Buyer

class Point(
    id: Id<Point> = Id.of(),
    buyerId: Id<Buyer>,
    balance: PointBalance = PointBalance.zero()
) {
    var id = id
        private set

    var buyerId = buyerId
        private set

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