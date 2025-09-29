package com.rockpay.core.domain.entity.product

import com.rockpay.common.enums.product.PromotionStatus
import com.rockpay.common.vo.Id
import com.rockpay.common.vo.Price
import java.time.LocalDateTime

class Promotion(
    id: Id<Promotion, Long> = Id.of(0),
    name: String,
    promotionalPrice: Price,
    startedAt: LocalDateTime,
    endedAt: LocalDateTime,
    status: PromotionStatus = PromotionStatus.PENDING,
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
        this.status = PromotionStatus.IN_PROGRESS
    }

    fun markAsCompleted() {
        this.status = PromotionStatus.FINISHED
    }
}