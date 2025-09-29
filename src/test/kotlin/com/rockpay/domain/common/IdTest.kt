package com.rockpay.domain.common

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class IdTest : StringSpec({

    "Id.of()는 기본값으로 0L을 가진 Id를 생성한다" {
        // given
        val id = Id.of<Any>()

        // when
        val value = id.value

        // then
        value shouldBe 0L
    }

    "Id.of()에 특정 값을 주면 그 값을 가진 Id를 생성한다" {
        // given
        val id = Id.of<Any>(123L)

        // when
        val value = id.value

        // then
        value shouldBe 123L
    }
})
