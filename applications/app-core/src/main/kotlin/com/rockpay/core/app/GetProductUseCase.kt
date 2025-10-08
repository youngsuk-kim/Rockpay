package com.rockpay.core.app

interface GetProductUseCase {
    fun invoke(query: GetProductQuery): GetProductQueryResult
}
