package com.rockpay.storage.db.core.entity.product

@JvmInline
value class Stock(
    val value: Int,
) {
    fun decrease(): Stock {
        require(value > 0) { "재고는 0보다 작을 수 없습니다." }
        return Stock(value - 1)
    }

    companion object {
        fun of(): Stock = Stock(0)
    }
}
