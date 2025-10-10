package com.rockpay.core.app

import com.rockpay.core.domain.entity.product.Product
import com.rockpay.support.domain.Price.Companion.toDisplayPrice

data class GetProductQueryResult(
    val id: Long,
    val name: String,
    val basePrice: String,
    val salePrice: String,
) {
    companion object {
        fun of(product: Product): GetProductQueryResult =
            GetProductQueryResult(
                id = product.id,
                name = product.name,
                basePrice = toDisplayPrice(product.basePrice),
                salePrice = toDisplayPrice(product.calculateSalePrice()),
            )
    }
}
