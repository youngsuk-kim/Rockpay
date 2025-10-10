package com.rockpay.client.product

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(value = "product-api", url = "\${product.api.url}")
internal interface ProductApi {
    @GetMapping("/v1/products/{productId}")
    fun getProduct(
        @PathVariable productId: Long,
    ): ProductResponseDto

    @GetMapping("/v1/products")
    fun getProducts(
        @RequestParam productIds: List<Long>,
    ): List<ProductResponseDto>
}
