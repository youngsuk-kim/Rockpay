package com.rockpay.domain.product

import com.rockpay.domain.Id
import com.rockpay.domain.Price

class Product(
    id: Id = Id.of(),
    name: String,
    basePrice: Price,
) {
    var id = id
        private set

    var name: String = name
        private set

    var basePrice: Price = basePrice
        private set

    var discountPrice: Price = basePrice
        private set
}
