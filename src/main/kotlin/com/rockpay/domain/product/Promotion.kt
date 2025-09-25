package com.rockpay.domain.product

import com.rockpay.domain.Id
import com.rockpay.domain.Price
import java.time.LocalDateTime

class Promotion(
    id: Id = Id.of(),
    name: String,
    promotionalPrice: Price,
    startedAt: LocalDateTime,
    endedAt: LocalDateTime
) {
    var id = id
        private set

    var name: String = name
        private set

    var promotionalPrice: Price = promotionalPrice
        private set

    var startedAt: LocalDateTime = startedAt
        private set

    var endedAt: LocalDateTime = endedAt
        private set
}