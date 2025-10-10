package com.rockpay.order.controller

data class CreateOrderRequest(
    val productIds: List<Long>,
    val quantities: List<Int>,
)
