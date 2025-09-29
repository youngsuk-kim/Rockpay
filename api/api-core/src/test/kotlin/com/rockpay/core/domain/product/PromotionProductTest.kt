package com.rockpay.core.domain.product

import com.rockpay.common.vo.Price
import com.rockpay.core.fixture.product.promotionProduct
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class PromotionProductTest : StringSpec({

    "프로모션 상품 생성 시 applied는 false 이다" {
        // given
        val promotionProduct = promotionProduct(applied = false)

        // when
        val applied = promotionProduct.applied

        // then
        applied shouldBe false
    }

    "할인 금액으로 상품의 할인 금액을 업데이트한다" {
        // given
        val promotionProduct = promotionProduct()

        // when
        promotionProduct.discount(Price.of(2500))

        // then
        promotionProduct.product.discountAmount.value shouldBe BigDecimal.valueOf(2500)
    }

    "apply() 호출 시 applied는 true가 된다" {
        // given
        val promotionProduct = promotionProduct(applied = false)

        // when
        promotionProduct.apply()

        // then
        promotionProduct.applied shouldBe true
    }
})
