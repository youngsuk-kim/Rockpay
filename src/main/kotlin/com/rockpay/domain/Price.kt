package com.rockpay.domain

import java.math.BigDecimal

@JvmInline
value class Price(val value: BigDecimal) {
    operator fun compareTo(other: Price): Int {
        return this.value.compareTo(other.value)
    }

    companion object {
        fun of(): Price = Price(BigDecimal.ZERO)
    }
}