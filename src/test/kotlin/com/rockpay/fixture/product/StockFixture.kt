package com.rockpay.fixture.product

import com.rockpay.domain.product.Stock

fun stock(value: Int = 0): Stock {
    return Stock(value)
}
