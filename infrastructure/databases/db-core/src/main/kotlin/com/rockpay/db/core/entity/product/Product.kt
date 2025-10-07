package com.rockpay.db.core.entity.product

import com.rockpay.common.vo.Price
import com.rockpay.db.core.Auditing
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "product")
class Product(
    id: Long = 0L,
    name: String,
    basePrice: Price = Price.of(),
    discountAmount: Price = Price.of(),
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = id
        private set

    @Column
    var name = name
        private set

    @Column
    var basePrice = basePrice
        private set

    @Column
    var discountAmount = discountAmount
        private set

    @Embedded
    var auditing: Auditing = Auditing()
        private set

    fun updateDiscountAmount(newDiscount: Price) {
        this.discountAmount = newDiscount
    }

    fun calculateSalePrice(): Price = this.basePrice - this.discountAmount
}
