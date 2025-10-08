package com.rockpay.order.app

import org.springframework.stereotype.Service

@Service
class CreateOrderService : CreateOrderUseCase {
    override fun invoke(command: CreateOrderCommand): CreatedOrder {
        TODO("Not yet implemented")
    }
}
