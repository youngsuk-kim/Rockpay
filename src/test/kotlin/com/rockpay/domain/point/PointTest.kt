package com.rockpay.domain.point

import com.rockpay.fixture.point.point
import com.rockpay.fixture.point.pointBalance
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PointTest : StringSpec({

    "포인트 생성 시 잔액은 0이다" {
        // given
        val point = point()

        // when
        val balance = point.balance

        // then
        balance shouldBe PointBalance.zero()
    }

    "포인트를 추가한다" {
        // given
        val point = point(balance = pointBalance(1000))

        // when
        point.addPoints(pointBalance(500))

        // then
        point.balance shouldBe PointBalance.of(1500)
    }

    "0 포인트를 추가하려 하면 예외가 발생한다" {
        // given
        val point = point()

        // when, then
        shouldThrow<IllegalArgumentException> {
            point.addPoints(pointBalance(0))
        }
    }

    "포인트를 사용한다" {
        // given
        val point = point(balance = pointBalance(1000))

        // when
        point.usePoints(pointBalance(500))

        // then
        point.balance shouldBe PointBalance.of(500)
    }

    "0 포인트를 사용하려 하면 예외가 발생한다" {
        // given
        val point = point(balance = pointBalance(1000))

        // when, then
        shouldThrow<IllegalArgumentException> {
            point.usePoints(pointBalance(0))
        }
    }

    "잔액보다 많은 포인트를 사용하려 하면 예외가 발생한다" {
        // given
        val point = point(balance = pointBalance(1000))

        // when, then
        shouldThrow<IllegalArgumentException> {
            point.usePoints(pointBalance(1100))
        }
    }
})
