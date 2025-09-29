package com.rockpay.core.domain.entity.product

import com.rockpay.common.vo.Id
import com.rockpay.common.vo.Price


class PromotionProduct(
    val id: Id<PromotionProduct, Long> = Id.of(0L),
    val product: Product,
    val promotion: Promotion,
    var discountedPrice: Price,
    var applied: Boolean = false,
) {

    fun discount(discountedPrice: Price) {
        this.product.updateDiscountAmount(discountedPrice)
    }

    fun apply() {
        this.applied = true
    }
}
