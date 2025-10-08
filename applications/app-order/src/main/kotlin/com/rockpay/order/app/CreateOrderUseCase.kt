package com.rockpay.order.app

interface CreateOrderUseCase {
    fun invoke(command: CreateOrderCommand): CreatedOrder
}
