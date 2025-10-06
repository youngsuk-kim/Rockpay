package com.rockpay.client.example

import com.rockpay.client.example.model.ExampleClientResult

internal data class ExampleResponseDto(
    val exampleResponseValue: String,
) {
    fun toResult(): ExampleClientResult = ExampleClientResult(exampleResponseValue)
}
