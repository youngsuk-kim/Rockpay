package com.rockpay.core.app

import com.rockpay.core.domain.entity.product.ProductNotFoundException
import com.rockpay.core.domain.entity.product.ProductRepository
import org.springframework.stereotype.Service

@Service
class GetProductService(
    private val productRepository: ProductRepository,
) : GetProductUseCase {
    override fun invoke(query: GetProductQuery): GetProductQueryResult {
        val product =
            productRepository.findById(query.productId)
                ?: throw ProductNotFoundException()

        return GetProductQueryResult.of(product)
    }

    override fun invoke(query: GetProductsQuery): List<GetProductQueryResult> {
        val products = productRepository.findAllByIds(query.productIds)

        return products.map { GetProductQueryResult.of(it) }
    }
}
