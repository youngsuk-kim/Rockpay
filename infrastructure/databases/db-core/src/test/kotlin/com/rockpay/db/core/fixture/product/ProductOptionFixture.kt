package com.rockpay.db.core.fixture.product

import com.rockpay.common.vo.Price
import com.rockpay.common.vo.Stock
import com.rockpay.db.core.entity.product.ProductOption

fun productOption(
    stock: Stock = stock(),
    price: Price = Price.of(0),
): ProductOption =
    ProductOption(
        stock = stock,
        price = price,
    )
