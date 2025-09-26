package com.rockpay.domain.product

import com.rockpay.domain.Id
import com.rockpay.domain.Price

class Product(
    id: Id<Product> = Id.of(),
    name: String,
    basePrice: Price,
    promotionPrice: Price,
) {
    var id = id
        private set

    var name: String = name
        private set

    var basePrice: Price = basePrice
        private set

    var discountPrice: Price = promotionPrice
        private set

    fun onPromotion(promotionPrice: Price) {
        this.discountPrice = promotionPrice
    }

    fun calculateSalePrice(): Price {
        return this.basePrice - this.discountPrice
    }
}
