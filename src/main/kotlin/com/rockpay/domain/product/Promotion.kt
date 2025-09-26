package com.rockpay.domain.product

import com.rockpay.domain.Id
import com.rockpay.domain.Price
import java.time.LocalDateTime

class Promotion(
    id: Id<Promotion> = Id.of(),
    name: String,
    promotionalPrice: Price,
    startedAt: LocalDateTime,
    endedAt: LocalDateTime,
    status: PromotionStatus,
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

    fun withStatus(status: PromotionStatus): Promotion {
        return Promotion(
            id = this.id,
            name = this.name,
            promotionalPrice = this.promotionalPrice,
            startedAt = this.startedAt,
            endedAt = this.endedAt,
            status = status
        )
    }
}