package com.rockpay.order.domain.repository

import com.rockpay.order.domain.entity.Order

interface OrderRepository {
    /**
     * Save an order to the repository
     * @param order The order to save
     * @return The saved order with its ID set
     */
    fun save(order: Order): Order

    /**
     * Find an order by its ID
     * @param id The ID of the order to find
     * @return The order if found, null otherwise
     */
    fun findById(id: Long): Order?
}
