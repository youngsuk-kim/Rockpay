package com.rockpay.core.domain.entity.product

interface ProductRepository {
    fun findById(id: Long): Product?

    fun findAllByIds(ids: List<Long>): List<Product>
}
