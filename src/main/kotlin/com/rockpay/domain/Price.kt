package com.rockpay.domain

import com.rockpay.domain.point.PointBalance
import java.math.BigDecimal

@JvmInline
value class Price(val value: BigDecimal) {
    operator fun compareTo(other: Price): Int {
        return this.value.compareTo(other.value)
    }

    operator fun plus(other: Price): Price {
        return Price(this.value.add(other.value))
    }

    operator fun minus(price: Price): Price {
        val result = this.value.subtract(price.value)
        return if (result.signum() < 0) {
            Price(BigDecimal.ZERO)
        } else {
            Price(result)
        }
    }

    operator fun minus(points: PointBalance): Price {
        val result = this.value.subtract(points.value)
        return if (result.signum() < 0) {
            Price(BigDecimal.ZERO)
        } else {
            Price(result)
        }
    }

    companion object {
        fun of(): Price = Price(BigDecimal.ZERO)
    }
}