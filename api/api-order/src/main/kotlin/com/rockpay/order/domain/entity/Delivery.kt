package com.rockpay.order.domain.entity

import com.rockpay.common.enums.order.DeliveryStatus
import com.rockpay.common.enums.order.DeliveryStatus.PENDING
import com.rockpay.common.vo.Id

class Delivery(
    id: Id<Delivery, Long> = Id.of(0),
    status: DeliveryStatus = PENDING,
) {
    var id = id
        private set

    var status: DeliveryStatus = status
        private set

    fun markAsShipped() {
        this.status = DeliveryStatus.SHIPPED
    }

    companion object {
        fun of(status: DeliveryStatus = PENDING): Delivery {
            return Delivery(Id.of(0), status)
        }
    }
}