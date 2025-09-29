package com.rockpay.domain.product

import com.rockpay.domain.common.Id
import com.rockpay.domain.common.Price

class ProductOption(
    id: Id<ProductOption, Long> = Id(0L),
    stock: Stock = Stock.of(),
    price: Price = Price.of(),
) {
    var id = id
        private set

    var stock: Stock = stock
        private set

    var price: Price = price
        private set

    fun decreaseStock() {
        this.stock = this.stock.decrease()
    }
}