package com.rockpay.db.order.entity

import com.rockpay.common.enums.order.DeliveryStatus
import com.rockpay.common.enums.order.DeliveryStatus.PENDING
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
    status: DeliveryStatus = PENDING,
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
        fun of(status: DeliveryStatus = PENDING): Delivery = Delivery(0L, status)
    }
}
