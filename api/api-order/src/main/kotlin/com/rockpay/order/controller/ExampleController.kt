package com.rockpay.order.controller

import com.rockpay.core.controller.v1.response.ExampleResponseDto
import com.rockpay.order.controller.request.ExampleRequestDto
import com.rockpay.order.domain.ExampleData
import com.rockpay.order.domain.ExampleService
import com.rockpay.support.response.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleController(
    val exampleExampleService: ExampleService,
) {
    @GetMapping("/get/{exampleValue}")
    fun exampleGet(
        @PathVariable exampleValue: String,
        @RequestParam exampleParam: String,
    ): ApiResponse<ExampleResponseDto> {
        val result = exampleExampleService.processExample(ExampleData(exampleValue, exampleParam))
        return ApiResponse.success(ExampleResponseDto(result.data))
    }

    @PostMapping("/post")
    fun examplePost(
        @RequestBody request: ExampleRequestDto,
    ): ApiResponse<ExampleResponseDto> {
        val result = exampleExampleService.processExample(request.toExampleData())
        return ApiResponse.success(ExampleResponseDto(result.data))
    }
}
