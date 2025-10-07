package com.rockpay.db.core.domain.coupon

import com.rockpay.db.core.fixture.coupon.buyerCoupon
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class BuyerCouponTest :
    StringSpec({

        "구매자 쿠폰 생성 시 isUsed는 false이다" {
            // given
            val buyerCoupon = buyerCoupon()

            // when
            val isUsed = buyerCoupon.isUsed

            // then
            isUsed shouldBe false
        }

        "쿠폰 사용 시 isUsed는 true가 된다" {
            // given
            val buyerCoupon = buyerCoupon(isUsed = false)

            // when
            buyerCoupon.useCoupon()

            // then
            buyerCoupon.isUsed shouldBe true
        }

        "이미 사용된 쿠폰을 다시 사용하려 하면 예외가 발생한다" {
            // given
            val buyerCoupon = buyerCoupon(isUsed = true)

            // when, then
            shouldThrow<IllegalStateException> {
                buyerCoupon.useCoupon()
            }
        }
    })
