package com.rockpay.order.domain.repository

import com.rockpay.order.domain.entity.Order

interface OrderRepository {
    fun save(order: Order): Order

    fun findById(id: Long): Order?
}
