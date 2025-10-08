package com.rockpay.core.db.repository

import com.rockpay.core.domain.entity.product.Product
import com.rockpay.core.domain.entity.product.ProductRepository
import org.springframework.stereotype.Repository

@Repository
class ProductRepositoryAdapter(
    private val productJpaRepository: ProductJpaRepository,
) : ProductRepository {
    override fun findById(id: Long): Product? = productJpaRepository.findProductById(id)
}
