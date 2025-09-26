package com.rockpay.domain.product

import com.rockpay.domain.Id
import com.rockpay.domain.Price

class PromotionProduct(
    id: Id<PromotionProduct> = Id.of(),
    product: Product,
    promotion: Promotion,
    discountedPrice: Price,
    applied: Boolean,
) {
    var id = id
        private set

    var product: Product = product
        private set

    var promotion: Promotion = promotion
        private set

    var discountedPrice: Price = discountedPrice
        private set

    var applied: Boolean = applied
        private set

    fun markApplied(): PromotionProduct {
        return PromotionProduct(
            id = this.id,
            product = this.product,
            promotion = this.promotion,
            discountedPrice = this.discountedPrice,
            applied = true
        )
    }
}
