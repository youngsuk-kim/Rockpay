package com.rockpay.core.domain.fixture.product

import com.rockpay.core.domain.entity.product.Product
import com.rockpay.core.domain.entity.product.Promotion
import com.rockpay.core.domain.entity.product.PromotionProduct
import com.rockpay.support.domain.Price

fun promotionProduct(
    product: Product = product(),
    promotion: Promotion = promotion(),
    discountedPrice: Price = Price.of(1000),
    applied: Boolean = false,
): PromotionProduct =
    PromotionProduct(
        product = product,
        promotion = promotion,
        discountedPrice = discountedPrice,
        applied = applied,
    )
