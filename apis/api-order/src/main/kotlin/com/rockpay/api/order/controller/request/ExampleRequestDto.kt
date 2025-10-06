package com.rockpay.api.order.controller.request

import com.rockpay.api.order.domain.ExampleData

data class ExampleRequestDto(
    val data: String,
) {
    fun toExampleData(): ExampleData = ExampleData(data, data)
}
