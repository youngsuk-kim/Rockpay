package com.rockpay.core.domain.product

import com.rockpay.core.domain.entity.product.Stock
import com.rockpay.core.fixture.product.stock
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StockTest :
    StringSpec({

        "Stock.of()는 0 값을 가진 Stock을 생성한다" {
            // given
            val zeroStock = Stock.of()

            // when
            val value = zeroStock.value

            // then
            value shouldBe 0
        }

        "재고를 1 감소시킨다" {
            // given
            val stock = stock(10)

            // when
            val decreasedStock = stock.decrease()

            // then
            decreasedStock.value shouldBe 9
        }

        "재고가 0일 때 감소시키려 하면 예외가 발생한다" {
            // given
            val stock = stock(0)

            // when, then
            shouldThrow<IllegalArgumentException> {
                stock.decrease()
            }
        }
    })
