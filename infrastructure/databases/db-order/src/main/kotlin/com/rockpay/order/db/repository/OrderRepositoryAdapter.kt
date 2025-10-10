package com.rockpay.order.db.repository

import com.rockpay.order.domain.entity.Order
import com.rockpay.order.domain.repository.OrderRepository
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryAdapter(
    private val orderJpaRepository: OrderJpaRepository,
) : OrderRepository {
    override fun save(order: Order): Order = orderJpaRepository.save(order)

    override fun findById(id: Long): Order? = orderJpaRepository.findOrderById(id)
}
