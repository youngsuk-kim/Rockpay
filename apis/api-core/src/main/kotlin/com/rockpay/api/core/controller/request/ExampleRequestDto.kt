package com.rockpay.api.core.controller.request

import com.rockpay.api.core.domain.ExampleData

data class ExampleRequestDto(
    val data: String,
) {
    fun toExampleData(): ExampleData = ExampleData(data, data)
}
