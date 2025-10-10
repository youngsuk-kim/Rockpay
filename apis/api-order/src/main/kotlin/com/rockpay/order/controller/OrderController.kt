package com.rockpay.order.controller

import com.rockpay.order.app.CreateOrderCommand
import com.rockpay.order.app.CreateOrderUseCase
import com.rockpay.order.app.CreatedOrder
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
    private val createOrderUseCase: CreateOrderUseCase,
) {
    @PostMapping("/v1/orders")
    fun placeOrder(
        @RequestBody request: CreateOrderRequest,
    ): ResponseEntity<CreatedOrder> {
        // 주문 요청에서 상품 ID 목록과 수량 목록을 가져옵니다
        val productIds = request.productIds
        val quantities = request.quantities

        // 주문 생성 명령을 생성합니다
        val command =
            CreateOrderCommand(
                productIds = productIds,
                quantities = quantities,
            )

        // 주문 생성 유스케이스를 실행하여 주문을 생성합니다
        val createdOrder = createOrderUseCase.invoke(command)

        // 생성된 주문과 함께 HTTP 201 Created 응답을 반환합니다
        return ResponseEntity(createdOrder, HttpStatus.CREATED)
    }
}
