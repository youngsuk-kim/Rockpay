package com.rockpay.order.support

import com.rockpay.order.domain.exception.OrderException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(OrderException::class)
    fun handleOrderException(e: OrderException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(e.message)

        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }
}
