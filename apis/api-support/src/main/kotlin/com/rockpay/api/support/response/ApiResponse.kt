package com.rockpay.api.support.response

import com.rockpay.api.support.error.ErrorMessage
import com.rockpay.api.support.error.ErrorType

data class ApiResponse<T> constructor(
    val result: ResultType,
    val data: T? = null,
    val error: ErrorMessage? = null,
) {
    companion object {
        fun success(): ApiResponse<Any> = ApiResponse(ResultType.SUCCESS, null, null)

        fun <S> success(data: S): ApiResponse<S> = ApiResponse(ResultType.SUCCESS, data, null)

        fun <S> error(
            error: ErrorType,
            errorData: Any? = null,
        ): ApiResponse<S> = ApiResponse(ResultType.ERROR, null, ErrorMessage(error, errorData))
    }
}
