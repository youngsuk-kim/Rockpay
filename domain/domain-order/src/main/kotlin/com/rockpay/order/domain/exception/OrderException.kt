package com.rockpay.order.domain.exception

data class OrderException(
    override val message: String,
) : RuntimeException()
