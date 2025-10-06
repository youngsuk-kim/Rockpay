package com.rockpay.api.order.controller

import com.rockpay.api.order.controller.request.ExampleRequestDto
import com.rockpay.api.order.controller.response.ExampleResponseDto
import com.rockpay.api.order.domain.ExampleData
import com.rockpay.api.order.domain.ExampleService
import com.rockpay.api.support.response.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleController(
    val exampleService: ExampleService,
) {
    @GetMapping("/get/{exampleValue}")
    fun exampleGet(
        @PathVariable exampleValue: String,
        @RequestParam exampleParam: String,
    ): ApiResponse<ExampleResponseDto> {
        val result = exampleService.processExample(ExampleData(exampleValue, exampleParam))
        return ApiResponse.success(ExampleResponseDto(result.data))
    }

    @PostMapping("/post")
    fun examplePost(
        @RequestBody request: ExampleRequestDto,
    ): ApiResponse<ExampleResponseDto> {
        val result = exampleService.processExample(request.toExampleData())
        return ApiResponse.success(ExampleResponseDto(result.data))
    }
}
