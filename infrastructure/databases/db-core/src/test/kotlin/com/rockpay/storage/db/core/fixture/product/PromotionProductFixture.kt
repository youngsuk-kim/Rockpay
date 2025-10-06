package com.rockpay.storage.db.core.fixture.product

import com.rockpay.common.vo.Price
import com.rockpay.storage.db.core.entity.product.Product
import com.rockpay.storage.db.core.entity.product.Promotion
import com.rockpay.storage.db.core.entity.product.PromotionProduct

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
