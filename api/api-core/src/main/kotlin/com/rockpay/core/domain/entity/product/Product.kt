package com.rockpay.core.domain.entity.product

import com.rockpay.common.vo.Id
import com.rockpay.common.vo.Price

class Product(
    val id: Id<Product, Long> = Id.of(0L),
    var name: String,
    var basePrice: Price,
    var discountAmount: Price = Price.of(),
) {
    fun updateDiscountAmount(newDiscount: Price) {
        this.discountAmount = newDiscount
    }

    fun calculateSalePrice(): Price = this.basePrice - this.discountAmount
}
