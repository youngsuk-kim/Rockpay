package com.rockpay.client.product

import com.rockpay.client.product.model.ProductClientResult
import org.springframework.stereotype.Component

@Component
class ProductClient internal constructor(
    private val productApi: ProductApi,
) {
    fun getProducts(productIds: List<Long>): List<ProductClientResult> = productApi.getProducts(productIds).data.map { it.toResult() }
}
