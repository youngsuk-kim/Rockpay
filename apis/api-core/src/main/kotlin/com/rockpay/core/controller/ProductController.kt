package com.rockpay.core.controller

import com.rockpay.core.app.GetProductQuery
import com.rockpay.core.app.GetProductQueryResult
import com.rockpay.core.app.GetProductUseCase
import com.rockpay.core.app.GetProductsQuery
import com.rockpay.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    private val getProductUseCase: GetProductUseCase,
) {
    @GetMapping("/v1/products/{productId}")
    fun getProduct(
        @PathVariable productId: Long,
    ): ApiResponse<GetProductQueryResult> = ApiResponse.success(getProductUseCase.invoke(GetProductQuery(productId)))

    @GetMapping("/v1/products")
    fun getProducts(
        @RequestParam productIds: List<Long>,
    ): ApiResponse<List<GetProductQueryResult>> = ApiResponse.success(getProductUseCase.invoke(GetProductsQuery(productIds)))
}
