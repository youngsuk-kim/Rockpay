package com.rockpay.core.domain.fixture.product

import com.rockpay.core.domain.entity.product.Promotion
import com.rockpay.core.domain.entity.product.PromotionStatus
import com.rockpay.support.domain.Price
import java.time.LocalDateTime

fun promotion(
    name: String = "프로모션1",
    promotionalPrice: Price = Price.of(1000),
    startedAt: LocalDateTime = LocalDateTime.of(2022, 1, 1, 0, 0, 0),
    endedAt: LocalDateTime = LocalDateTime.of(2022, 1, 1, 0, 0, 0).plusDays(1),
    status: PromotionStatus = PromotionStatus.PENDING,
): Promotion =
    Promotion(
        name = name,
        promotionalPrice = promotionalPrice,
        startedAt = startedAt,
        endedAt = endedAt,
        status = status,
    )
