package com.rockpay.core.domain.product

import com.rockpay.common.enums.product.PromotionStatus
import com.rockpay.core.fixture.product.promotion
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PromotionTest : StringSpec({

    "프로모션 생성 시 기본 상태는 PENDING 이다" {
        // given
        val promotion = promotion()

        // when
        val status = promotion.status

        // then
        status shouldBe PromotionStatus.PENDING
    }

    "프로모션 상태를 IN_PROGRESS로 변경한다" {
        // given
        val promotion = promotion(status = PromotionStatus.PENDING)

        // when
        promotion.markAsInProgress()

        // then
        promotion.status shouldBe PromotionStatus.IN_PROGRESS
    }

    "프로모션 상태를 FINISHED로 변경한다" {
        // given
        val promotion = promotion(status = PromotionStatus.IN_PROGRESS)

        // when
        promotion.markAsCompleted()

        // then
        promotion.status shouldBe PromotionStatus.FINISHED
    }
})
