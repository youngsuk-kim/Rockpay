package com.rockpay.core.controller.request

import com.rockpay.core.domain.ExampleData

data class ExampleRequestDto(
    val data: String,
) {
    fun toExampleData(): ExampleData = ExampleData(data, data)
}
