package com.rockpay.order.controller

import com.rockpay.order.app.CreateOrderUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
    private val createOrderUseCase: CreateOrderUseCase,
) {
    @PostMapping("/v1/orders")
    fun placeOrder() {
        // TODO: Implement
    }
}
