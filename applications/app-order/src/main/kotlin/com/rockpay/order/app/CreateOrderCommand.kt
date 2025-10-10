package com.rockpay.order.app

data class CreateOrderCommand(
    val productIds: List<Long>,
    val quantities: List<Int>,
)
