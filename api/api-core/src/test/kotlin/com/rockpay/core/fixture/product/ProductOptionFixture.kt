package com.rockpay.core.fixture.product

import com.rockpay.common.vo.Price
import com.rockpay.core.domain.entity.product.ProductOption
import com.rockpay.core.domain.entity.product.Stock

fun productOption(
    stock: Stock = stock(),
    price: Price = Price.of(0),
): ProductOption =
    ProductOption(
        stock = stock,
        price = price,
    )
