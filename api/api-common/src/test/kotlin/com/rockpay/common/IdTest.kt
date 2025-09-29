package com.rockpay.common

import com.rockpay.common.vo.Id
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class IdTest : StringSpec({

    "Id.of()에 특정 값을 주면 그 값을 가진 Id를 생성한다" {
        // given
        val id = Id.of<Any, Long>(123L)

        // when
        val value = id.value

        // then
        value shouldBe 123L
    }
})
