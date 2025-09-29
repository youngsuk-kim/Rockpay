package com.rockpay.core.domain.entity.point

import com.rockpay.common.vo.Id
import com.rockpay.core.domain.entity.user.Buyer
import java.math.BigDecimal

class Point(
    val id: Id<Point, Long> = Id.of(0L),
    val buyerId: Id<Buyer, Long>,
    var balance: PointBalance = PointBalance.zero()
) {

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
