package com.rockpay.core.domain.entity.product

import com.rockpay.core.domain.fixture.product.productOption
import com.rockpay.core.domain.fixture.product.stock
import com.rockpay.support.domain.Price
import com.rockpay.support.domain.Stock
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProductOptionTest :
    StringSpec({

        "ProductOption 생성 시 기본값으로 재고와 가격이 0으로 설정된다" {
            // given
            val productOption = productOption()

            // then
            productOption.stock shouldBe Stock.of()
            productOption.price shouldBe Price.of()
        }

        "재고를 1 감소시킨다" {
            // given
            val productOption =
                productOption(
                    stock = stock(10),
                )

            // when
            productOption.decreaseStock()

            // then
            productOption.stock shouldBe Stock(9)
        }

        "재고가 0일 때 감소시키려 하면 예외가 발생한다" {
            // given
            val productOption =
                productOption(
                    stock = stock(0),
                )

            // when, then
            shouldThrow<IllegalArgumentException> {
                productOption.decreaseStock()
            }
        }
    })
