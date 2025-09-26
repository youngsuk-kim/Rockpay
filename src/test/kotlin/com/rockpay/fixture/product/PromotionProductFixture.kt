package com.rockpay.fixture.product

import com.rockpay.domain.Price
import com.rockpay.domain.product.Product
import com.rockpay.domain.product.Promotion
import com.rockpay.domain.product.PromotionProduct

fun promotionProduct(
    product: Product = product(),
    promotion: Promotion = promotion(),
    discountedPrice: Price = Price.of(1000),
    applied: Boolean = false
): PromotionProduct {
    return PromotionProduct(
        product = product,
        promotion = promotion,
        discountedPrice = discountedPrice,
        applied = applied
    )
}
