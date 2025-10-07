package com.rockpay.db.core.entity.product

import com.rockpay.common.vo.Price
import com.rockpay.db.core.Auditing
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "promotion_product")
class PromotionProduct(
    id: Long = 0L,
    product: Product,
    promotion: Promotion,
    discountedPrice: Price,
    applied: Boolean = false,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = id
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    var product = product
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promotion_id")
    var promotion = promotion
        private set

    @Column
    var discountedPrice = discountedPrice
        private set

    @Embedded
    var auditing: Auditing = Auditing()
        private set

    @Column
    var applied = applied
        private set

    fun discount(discountedPrice: Price) {
        this.product.updateDiscountAmount(discountedPrice)
    }

    fun apply() {
        this.applied = true
    }
}
