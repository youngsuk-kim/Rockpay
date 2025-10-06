package com.rockpay.storage.db.core.fixture.product

import com.rockpay.common.vo.Price
import com.rockpay.storage.db.core.entity.product.Product

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
