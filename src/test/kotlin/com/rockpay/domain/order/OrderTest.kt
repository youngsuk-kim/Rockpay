package com.rockpay.domain.order

import com.rockpay.domain.common.Price
import com.rockpay.domain.point.PointBalance
import com.rockpay.fixture.coupon.coupon
import com.rockpay.fixture.order.order
import com.rockpay.fixture.order.orderItem
import com.rockpay.fixture.product.product
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OrderTest : StringSpec({

    "PENDING 상태의 주문을 PAID 로 변경할 수 있다" {
        // given
        val order = order(orderStatus = OrderStatus.PENDING)

        // when
        order.markAsPaid()

        // then
        order.orderStatus shouldBe OrderStatus.PAID
    }

    "PENDING 상태가 아닌 주문을 PAID 로 변경하면 예외가 발생한다" {
        // given
        val order = order(orderStatus = OrderStatus.PAID)

        // when, then
        shouldThrow<IllegalStateException> {
            order.markAsPaid()
        }
    }

    "쿠폰과 포인트를 사용하여 최종 결제 금액을 계산한다" {
        // given
        val orderItem1 = orderItem(product = product(basePrice = 10000), quantity = 2)
        val orderItem2 = orderItem(product = product(basePrice = 20000), quantity = 1)
        val order = order(orderItems = listOf(orderItem1, orderItem2))
        val coupon = coupon(discountAmount = 5000)
        val pointsToUse = PointBalance.of(3000)

        // when
        val finalPaymentAmount = order.calculateFinalPaymentAmount(coupon, pointsToUse)

        // then
        finalPaymentAmount shouldBe Price.of(32000)
    }

    "쿠폰만 사용하여 최종 결제 금액을 계산한다" {
        // given
        val orderItem1 = orderItem(product = product(basePrice = 10000), quantity = 2)
        val orderItem2 = orderItem(product = product(basePrice = 20000), quantity = 1)
        val order = order(orderItems = listOf(orderItem1, orderItem2))
        val coupon = coupon(discountAmount = 5000)

        // when
        val finalPaymentAmount = order.calculateFinalPaymentAmount(coupon)

        // then
        finalPaymentAmount shouldBe Price.of(35000)
    }

    "포인트만 사용하여 최종 결제 금액을 계산한다" {
        // given
        val orderItem1 = orderItem(product = product(basePrice = 10000), quantity = 2)
        val orderItem2 = orderItem(product = product(basePrice = 20000), quantity = 1)
        val order = order(orderItems = listOf(orderItem1, orderItem2))
        val pointsToUse = PointBalance.of(3000)

        // when
        val finalPaymentAmount = order.calculateFinalPaymentAmount(pointsToUse = pointsToUse)

        // then
        finalPaymentAmount shouldBe Price.of(37000)
    }

    "쿠폰과 포인트 없이 최종 결제 금액을 계산한다" {
        // given
        val orderItem1 = orderItem(product = product(basePrice = 10000), quantity = 2)
        val orderItem2 = orderItem(product = product(basePrice = 20000), quantity = 1)
        val order = order(orderItems = listOf(orderItem1, orderItem2))

        // when
        val finalPaymentAmount = order.calculateFinalPaymentAmount()

        // then
        finalPaymentAmount shouldBe Price.of(40000)
    }
})
