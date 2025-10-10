package com.rockpay.core.support

import com.rockpay.core.domain.exception.CoreException
import com.rockpay.core.support.error.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(CoreException::class)
    fun handleCoreException(e: CoreException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(e.message)

        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }
}
