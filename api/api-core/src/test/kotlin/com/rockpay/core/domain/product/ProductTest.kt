package com.rockpay.core.domain.product

import com.rockpay.common.vo.Price
import com.rockpay.core.fixture.product.product
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProductTest : StringSpec({

    "상품 할인 금액을 업데이트한다" {
        // given
        val product = product(basePrice = 10000)

        // when
        product.updateDiscountAmount(Price.of(2000))

        // then
        product.discountAmount shouldBe Price.of(2000)
    }

    "상품 판매가를 계산한다" {
        // given
        val product =
            product(basePrice = 10000, discountAmount = 2000)

        // when
        val salePrice = product.calculateSalePrice()

        // then
        salePrice shouldBe Price.of(8000)
    }

    "할인 금액이 상품 가격보다 클 경우 판매가는 0원이 된다" {
        // given
        val product =
            product(basePrice = 10000, discountAmount = 12000)

        // when
        val salePrice = product.calculateSalePrice()

        // then
        salePrice shouldBe Price.of(0)
    }
})
