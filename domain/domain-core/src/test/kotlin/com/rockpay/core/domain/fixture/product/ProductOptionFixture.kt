package com.rockpay.core.domain.fixture.product

import com.rockpay.core.domain.entity.product.ProductOption
import com.rockpay.support.domain.Price
import com.rockpay.support.domain.Stock

fun productOption(
    stock: Stock = stock(),
    price: Price = Price.of(0),
): ProductOption =
    ProductOption(
        stock = stock,
        price = price,
    )
