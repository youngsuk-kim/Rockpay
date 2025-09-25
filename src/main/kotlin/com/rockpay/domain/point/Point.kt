package com.rockpay.domain.point

import com.rockpay.domain.Id
import java.math.BigDecimal

class Point(
    id: Id = Id.of(),
    buyerId: Id,
    balance: PointBalance = PointBalance.zero()
) {
    var id: Id = id
        private set

    var buyerId: Id = buyerId
        private set

    var balance: PointBalance = balance
        private set

    fun addPoints(amount: PointBalance): Point {
        require(amount.value > BigDecimal.ZERO) { "추가할 포인트는 0보다 커야 합니다." }
        return Point(id = this.id, buyerId = this.buyerId, balance = this.balance + amount)
    }

    fun usePoints(amount: PointBalance): Point {
        require(amount.value > BigDecimal.ZERO) { "사용할 포인트는 0보다 커야 합니다." }
        require(this.balance >= amount) { "잔액이 부족합니다." }
        return Point(id = this.id, buyerId = this.buyerId, balance = this.balance - amount)
    }
}