package com.rockpay.order.domain

import com.rockpay.common.enums.order.DeliveryStatus
import com.rockpay.order.domain.entity.Delivery
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DeliveryTest : StringSpec({

    "Delivery.of()로 배송 정보 생성 시 PENDING 상태로 생성된다" {
        // given
        val delivery = Delivery.of()

        // when
        val status = delivery.status

        // then
        status shouldBe DeliveryStatus.PENDING
    }

    "배송 상태를 SHIPPED로 변경한다" {
        // given
        val delivery = Delivery(status = DeliveryStatus.PENDING)

        // when
        delivery.markAsShipped()

        // then
        delivery.status shouldBe DeliveryStatus.SHIPPED
    }
})
