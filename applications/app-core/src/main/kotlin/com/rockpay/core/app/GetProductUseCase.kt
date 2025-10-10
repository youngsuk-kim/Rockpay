package com.rockpay.core.app

interface GetProductUseCase {
    fun invoke(query: GetProductQuery): GetProductQueryResult

    fun invoke(query: GetProductsQuery): List<GetProductQueryResult>
}
