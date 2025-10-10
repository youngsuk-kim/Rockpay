package com.rockpay.client.product.model

import com.rockpay.support.domain.Price

data class ProductClientResult(
    val id: Long,
    val name: String,
    val basePrice: Price,
    val salePrice: Price,
)
