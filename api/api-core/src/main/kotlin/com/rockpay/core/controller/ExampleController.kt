package com.rockpay.core.controller

import com.rockpay.core.controller.request.ExampleRequestDto
import com.rockpay.core.controller.response.ExampleResponseDto
import com.rockpay.core.domain.ExampleData
import com.rockpay.core.domain.ExampleService
import com.rockpay.support.response.ApiResponse
import org.springframework.web.bind.annotation.*

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
