package com.rockpay.core.controller

import com.rockpay.core.app.GetProductQuery
import com.rockpay.core.app.GetProductUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    private val getProductUseCase: GetProductUseCase,
) {
    @GetMapping("/v1/products/{productId}")
    fun getProduct(
        @PathVariable productId: Long,
    ) = getProductUseCase.invoke(GetProductQuery(productId))
}
