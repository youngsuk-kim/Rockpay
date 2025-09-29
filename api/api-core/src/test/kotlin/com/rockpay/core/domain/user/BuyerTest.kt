package com.rockpay.core.domain.user

import com.rockpay.core.fixture.user.buyer
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class BuyerTest :
    StringSpec({

        "Buyer.of()로 구매자 생성 시 정보가 올바르게 설정된다" {
            // given
            val buyer = buyer(name = "구매자1", email = "test@rockpay.com")

            // when
            val name = buyer.name
            val email = buyer.email

            // then
            name shouldBe "구매자1"
            email shouldBe "test@rockpay.com"
        }

        "구매자의 이메일을 변경한다" {
            // given
            val buyer = buyer()

            // when
            buyer.updateEmail("new-test@rockpay.com")

            // then
            buyer.email shouldBe "new-test@rockpay.com"
        }
    })
