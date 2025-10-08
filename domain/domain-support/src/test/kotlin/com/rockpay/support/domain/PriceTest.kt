package com.rockpay.support.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class PriceTest :
    StringSpec({

        "Price.of()는 0 값을 가진 Price를 생성한다" {
            // given
            val zeroPrice = Price.of()

            // when
            val value = zeroPrice.value

            // then
            value shouldBe BigDecimal.ZERO
        }

        "두 Price를 더한 값을 가진 새로운 Price를 반환한다" {
            // given
            val price1 = Price(BigDecimal.valueOf(1000))
            val price2 = Price(BigDecimal.valueOf(500))

            // when
            val result = price1 + price2

            // then
            result.value shouldBe BigDecimal.valueOf(1500)
        }

        "Price를 뺐을 때 음수가 아니면 정상적으로 차감된다" {
            // given
            val price1 = Price(BigDecimal.valueOf(1000))
            val price2 = Price(BigDecimal.valueOf(500))

            // when
            val result = price1 - price2

            // then
            result.value shouldBe BigDecimal.valueOf(500)
        }

        "Price를 뺐을 때 결과가 0이면 0을 가진 Price를 반환한다" {
            // given
            val price1 = Price(BigDecimal.valueOf(1000))
            val price2 = Price(BigDecimal.valueOf(1000))

            // when
            val result = price1 - price2

            // then
            result.value shouldBe BigDecimal.ZERO
        }

        "Price를 뺐을 때 음수이면 0을 가진 Price를 반환한다" {
            // given
            val price1 = Price(BigDecimal.valueOf(500))
            val price2 = Price(BigDecimal.valueOf(1000))

            // when
            val result = price1 - price2

            // then
            result.value shouldBe BigDecimal.ZERO
        }

        "Price에 수량을 곱한 값을 가진 새로운 Price를 반환한다" {
            // given
            val price = Price(BigDecimal.valueOf(1000))
            val quantity = 3

            // when
            val result = price * quantity

            // then
            result.value shouldBe BigDecimal.valueOf(3000)
        }

        "두 Price의 값을 비교한다" {
            // given
            val price1000 = Price(BigDecimal.valueOf(1000))
            val price500 = Price(BigDecimal.valueOf(500))
            val anotherPrice1000 = Price(BigDecimal.valueOf(1000))

            // when
            val result1 = price1000 > price500
            val result2 = price500 < price1000
            val result3 = price1000 == anotherPrice1000

            // then
            result1 shouldBe true
            result2 shouldBe true
            result3 shouldBe true
        }
    })
