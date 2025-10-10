package com.rockpay.order.db.repository

import com.rockpay.order.domain.entity.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderJpaRepository : JpaRepository<Order, Long> {
    fun findOrderById(id: Long): Order?
}
