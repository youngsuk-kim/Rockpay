package com.rockpay.domain.product

import com.rockpay.domain.Id
import com.rockpay.domain.Price
import com.rockpay.domain.product.PromotionStatus.FINISHED
import com.rockpay.domain.product.PromotionStatus.IN_PROGRESS
import com.rockpay.domain.product.PromotionStatus.PENDING
import java.time.LocalDateTime

class Promotion(
    id: Id<Promotion> = Id.of(),
    name: String,
    promotionalPrice: Price,
    startedAt: LocalDateTime,
    endedAt: LocalDateTime,
    status: PromotionStatus = PENDING,
) {
    var id = id
        private set

    var name: String = name
        private set

    var promotionalPrice: Price = promotionalPrice
        private set

    var status: PromotionStatus = status
        private set

    var startedAt: LocalDateTime = startedAt
        private set

    var endedAt: LocalDateTime = endedAt
        private set

    fun markAsInProgress() {
        this.status = IN_PROGRESS
    }

    fun markAsCompleted() {
        this.status = FINISHED
    }
}