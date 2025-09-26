package com.rockpay.domain.product

import com.rockpay.domain.Id
import com.rockpay.domain.Price

class ProductOption(
    id: Id<ProductOption> = Id.of(),
    stock: Stock = Stock.of(),
    price: Price = Price.of(),
) {
    var id = id
        private set

    var stock: Stock = stock
        private set

    var price: Price = price
        private set

    fun decreaseStock(stock: Stock) {
        stock.decrease()
    }
}