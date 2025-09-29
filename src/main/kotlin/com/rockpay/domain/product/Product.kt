package com.rockpay.domain.product

import com.rockpay.domain.common.Id
import com.rockpay.domain.common.Price

class Product(
    id: Id<Product, Long> = Id(0L),
    name: String,
    basePrice: Price,
    discountAmount: Price = Price.of()
) {
    var id = id
        private set

    var name: String = name
        private set

    var basePrice: Price = basePrice
        private set

    var discountAmount: Price = discountAmount
        private set

    fun updateDiscountAmount(newDiscount: Price) {
        this.discountAmount = newDiscount
    }

    fun calculateSalePrice(): Price {
        return this.basePrice - this.discountAmount
    }
}
