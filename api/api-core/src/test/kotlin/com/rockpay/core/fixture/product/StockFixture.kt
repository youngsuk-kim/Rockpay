package com.rockpay.core.fixture.product

import com.rockpay.core.domain.entity.product.Stock

fun stock(value: Int = 0): Stock {
    return Stock(value)
}
