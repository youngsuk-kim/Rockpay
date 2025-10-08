package com.rockpay.order.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "delivery")
class Delivery(
    id: Long = 0L,
    status: DeliveryStatus = DeliveryStatus.PENDING,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = id
        private set

    @Column(name = "status")
    var status: DeliveryStatus = status
        private set

    fun markAsShipped() {
        this.status = DeliveryStatus.SHIPPED
    }

    companion object {
        fun of(status: DeliveryStatus = DeliveryStatus.PENDING): Delivery = Delivery(0L, status)
    }
}
