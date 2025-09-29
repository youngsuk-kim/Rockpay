package com.rockpay.order.controller.request

import com.rockpay.order.domain.ExampleData

data class ExampleRequestDto(
    val data: String,
) {
    fun toExampleData(): ExampleData {
        return ExampleData(data, data)
    }
}
