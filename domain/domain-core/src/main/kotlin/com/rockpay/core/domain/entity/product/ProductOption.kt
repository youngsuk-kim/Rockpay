package com.rockpay.core.domain.entity.product

import com.rockpay.support.domain.Auditing
import com.rockpay.support.domain.Price
import com.rockpay.support.domain.Stock
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "product_option")
class ProductOption(
    id: Long = 0L,
    stock: Stock = Stock.of(),
    price: Price = Price.of(),
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = id
        private set

    @Column
    var stock: Stock = stock
        private set

    @Column
    var price: Price = price
        private set

    @Embedded
    var auditing: Auditing = Auditing()
        private set

    fun decreaseStock() {
        this.stock = this.stock.decrease()
    }
}
