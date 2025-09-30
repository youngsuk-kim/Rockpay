package com.rockpay.storage.db.core.domain.coupon

import com.rockpay.storage.db.core.fixture.coupon.coupon
import com.rockpay.storage.db.core.fixture.now
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CouponTest :
    StringSpec({
        "쿠폰이 만료되지 않았다면 isExpired는 false를 반환한다" {
            // given
            val coupon =
                coupon(
                    expirationDate = now.plusDays(1),
                )

            // when
            val isExpired = coupon.isExpired(now)

            // then
            isExpired shouldBe false
        }

        "쿠폰이 만료되었다면 isExpired는 true를 반환한다" {
            // given
            val coupon =
                coupon(
                    expirationDate = now.minusDays(1),
                )

            // when
            val isExpired = coupon.isExpired(now)

            // then
            isExpired shouldBe true
        }

        "쿠폰 만료일과 현재 시간이 같다면 isExpired는 false를 반환한다" {
            // given
            val coupon =
                coupon(expirationDate = now)

            // when
            val isExpired = coupon.isExpired(now)

            // then
            isExpired shouldBe false
        }
    })
