package com.rockpay.core.fixture.product

import com.rockpay.common.vo.Price
import com.rockpay.core.domain.entity.product.Product
import com.rockpay.core.domain.entity.product.Promotion
import com.rockpay.core.domain.entity.product.PromotionProduct

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
