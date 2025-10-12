package com.rockpay.client.product

import com.rockpay.client.product.model.ProductClientResult
import com.rockpay.support.domain.Price
import java.math.BigDecimal

data class ProductResponseDto(
    val id: Long,
    val name: String,
    val basePrice: String,
    val salePrice: String,
) {
    fun toResult(): ProductClientResult =
        ProductClientResult(
            id = id,
            name = name,
            basePrice = Price(BigDecimal(basePrice)),
            salePrice = Price(BigDecimal(salePrice)),
        )
}
