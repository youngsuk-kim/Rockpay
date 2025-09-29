package com.rockpay.fixture.product

import com.rockpay.domain.common.Price
import com.rockpay.domain.product.Product

fun product(name: String = "상품1", basePrice: Long = 10000, discountAmount: Long = 0): Product {
    return Product(
        name = name,
        basePrice = Price.of(basePrice),
        discountAmount = Price.of(discountAmount)
    )
}
