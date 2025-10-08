package com.rockpay.core.db.repository

import com.rockpay.core.domain.entity.product.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductJpaRepository : JpaRepository<Product, Long> {
    fun findProductById(id: Long): Product?
}
