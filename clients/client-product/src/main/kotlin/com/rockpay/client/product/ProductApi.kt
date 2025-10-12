package com.rockpay.client.product

import com.rockpay.client.product.model.ApiResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(value = "product-api", url = "\${product.api.url}")
internal interface ProductApi {
    @GetMapping("/v1/products/{productId}")
    fun getProduct(
        @PathVariable productId: Long,
    ): ApiResponse<ProductResponseDto>

    @GetMapping("/v1/products")
    fun getProducts(
        @RequestParam productIds: List<Long>,
    ): ApiResponse<List<ProductResponseDto>>
}
