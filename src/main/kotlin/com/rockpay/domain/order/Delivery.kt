package com.rockpay.domain.order

import com.rockpay.domain.Id
import com.rockpay.domain.order.DeliveryStatus.PENDING
import com.rockpay.domain.order.DeliveryStatus.SHIPPED

class Delivery(
    id: Id<Delivery> = Id.of(),
    status: DeliveryStatus = PENDING,
) {
    var id = id
        private set

    var status: DeliveryStatus = status
        private set

    fun shippedDelivery(): Delivery {
        return Delivery(id, SHIPPED)
    }

    companion object {
        fun of(): Delivery {
            return Delivery(Id.of(), PENDING)
        }
    }
}