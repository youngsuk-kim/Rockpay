package com.rockpay.domain.product

import com.rockpay.domain.Id
import com.rockpay.domain.Price

class PromotionProduct(
    id: Id = Id.of(),
    product: Product,
    promotion: Promotion,
    discountedPrice: Price
) {
    var id = id
        private set

    var product: Product = product
        private set

    var promotion: Promotion = promotion
        private set

    var discountedPrice: Price = discountedPrice
        private set
}
