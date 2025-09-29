package com.rockpay.common.vo

import java.math.BigDecimal

@JvmInline
value class Price(
    val value: BigDecimal,
) {
    operator fun compareTo(other: Price): Int = this.value.compareTo(other.value)

    operator fun plus(other: Price): Price = Price(this.value.add(other.value))

    operator fun minus(price: Price): Price = subtractAndFloorAtZero(price.value)

    operator fun times(quantity: Int): Price = Price(this.value.multiply(BigDecimal.valueOf(quantity.toLong())))

    private fun subtractAndFloorAtZero(amount: BigDecimal): Price {
        val result = this.value.subtract(amount)
        return if (result.signum() < 0) {
            Price(BigDecimal.ZERO)
        } else {
            Price(result)
        }
    }

    companion object {
        fun of(): Price = Price(BigDecimal.ZERO)

        fun of(value: Long): Price = Price(BigDecimal.valueOf(value))
    }
}
