package com.rockpay.fixture.product

import com.rockpay.domain.Price
import com.rockpay.domain.product.ProductOption
import com.rockpay.domain.product.Stock

fun productOption(stock: Stock = stock(), price: Price = Price.of(0)): ProductOption {
    return ProductOption(
        stock = stock,
        price = price
    )
}
