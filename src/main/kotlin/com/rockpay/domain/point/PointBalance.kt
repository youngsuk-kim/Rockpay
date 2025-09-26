package com.rockpay.domain.point

import java.math.BigDecimal

@JvmInline
value class PointBalance(val value: BigDecimal) {
    init {
        require(value >= BigDecimal.ZERO) { "포인트 잔액은 0보다 작을 수 없습니다." }
    }

    operator fun plus(other: PointBalance): PointBalance {
        return PointBalance(this.value.add(other.value))
    }

    operator fun minus(other: PointBalance): PointBalance {
        return PointBalance(this.value.subtract(other.value))
    }

    operator fun compareTo(other: PointBalance): Int {
        return this.value.compareTo(other.value)
    }

    companion object {
        fun zero(): PointBalance = PointBalance(BigDecimal.ZERO)
        fun of(value: Long): PointBalance = PointBalance(BigDecimal.valueOf(value))
    }
}
