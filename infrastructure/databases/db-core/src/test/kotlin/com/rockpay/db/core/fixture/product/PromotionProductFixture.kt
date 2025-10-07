package com.rockpay.db.core.fixture.product

import com.rockpay.common.vo.Price
import com.rockpay.db.core.entity.product.Product
import com.rockpay.db.core.entity.product.Promotion
import com.rockpay.db.core.entity.product.PromotionProduct

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
