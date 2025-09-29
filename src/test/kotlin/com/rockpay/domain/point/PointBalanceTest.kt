package com.rockpay.domain.point

import com.rockpay.fixture.point.pointBalance
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PointBalanceTest : StringSpec({

    "PointBalance.zero()는 0 값을 가진 PointBalance를 생성한다" {
        // when
        val zeroBalance = PointBalance.zero()

        // then
        zeroBalance shouldBe PointBalance.of(0)
    }

    "두 PointBalance를 더한 값을 가진 새로운 PointBalance를 반환한다" {
        // given
        val balance1 = pointBalance(1000)
        val balance2 = pointBalance(500)

        // when
        val result = balance1 + balance2

        // then
        result shouldBe PointBalance.of(1500)
    }

    "PointBalance를 뺀 값을 가진 새로운 PointBalance를 반환한다" {
        // given
        val balance1 = pointBalance(1000)
        val balance2 = pointBalance(500)

        // when
        val result = balance1 - balance2

        // then
        result shouldBe PointBalance.of(500)
    }

    "두 PointBalance의 값을 비교한다" {
        // given
        val balance1000 = pointBalance(1000)
        val balance500 = pointBalance(500)
        val anotherBalance1000 = pointBalance(1000)

        // when
        val result1 = balance1000 > balance500
        val result2 = balance500 < balance1000
        val result3 = balance1000 >= anotherBalance1000
        val result4 = balance1000 <= anotherBalance1000

        // then
        result1 shouldBe true
        result2 shouldBe true
        result3 shouldBe true
        result4 shouldBe true
    }

    "0보다 작은 값으로 PointBalance를 생성하려 하면 예외가 발생한다" {
        // given
        val amount = -1L

        // when, then
        shouldThrow<IllegalArgumentException> {
            pointBalance(amount)
        }
    }
})
