package com.rockpay.core.domain.entity.product

import com.rockpay.common.vo.Id
import com.rockpay.common.vo.Price

class ProductOption(
    id: Id<ProductOption, Long> = Id.of(0),
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
