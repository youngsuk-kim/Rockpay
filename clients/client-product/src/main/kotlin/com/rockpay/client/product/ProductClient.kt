package com.rockpay.client.product

import com.rockpay.client.product.model.ProductClientResult
import org.springframework.stereotype.Component

@Component
class ProductClient internal constructor(
    private val productApi: ProductApi,
) {
    fun getProduct(productId: Long): ProductClientResult = productApi.getProduct(productId).toResult()

    fun getProducts(productIds: List<Long>): List<ProductClientResult> = productApi.getProducts(productIds).map { it.toResult() }
}
