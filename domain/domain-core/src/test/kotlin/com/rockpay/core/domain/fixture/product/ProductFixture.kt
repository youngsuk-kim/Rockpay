package com.rockpay.core.domain.fixture.product

import com.rockpay.core.domain.entity.product.Product
import com.rockpay.support.domain.Price

fun product(
    name: String = "상품1",
    basePrice: Long = 10000,
    discountAmount: Long = 0,
): Product =
    Product(
        name = name,
        basePrice = Price.of(basePrice),
        discountAmount = Price.of(discountAmount),
    )
