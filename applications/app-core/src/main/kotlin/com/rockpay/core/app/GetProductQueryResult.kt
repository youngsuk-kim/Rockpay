package com.rockpay.core.app

import com.rockpay.core.domain.entity.product.Product

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
                basePrice = product.basePrice.toString(),
                salePrice = product.basePrice.toString(),
            )
    }
}
