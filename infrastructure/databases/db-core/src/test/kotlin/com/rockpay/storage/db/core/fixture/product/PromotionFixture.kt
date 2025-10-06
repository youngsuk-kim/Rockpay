package com.rockpay.storage.db.core.fixture.product

import com.rockpay.common.enums.product.PromotionStatus
import com.rockpay.common.vo.Price
import com.rockpay.storage.db.core.entity.product.Promotion
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
