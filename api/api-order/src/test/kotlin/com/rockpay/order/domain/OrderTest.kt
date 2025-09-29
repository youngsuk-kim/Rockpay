package com.rockpay.order.domain

import com.rockpay.common.enums.order.OrderStatus
import com.rockpay.common.vo.Id
import com.rockpay.common.vo.Price
import com.rockpay.order.fixture.order
import com.rockpay.order.fixture.orderItem
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OrderTest :
    StringSpec({

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
            val orderItem1 =
                orderItem(
                    productId = Id.ofExternal(1L),
                    quantity = 2,
                    price = Price.of(10000),
                )
            val orderItem2 =
                orderItem(
                    productId = Id.ofExternal(2L),
                    quantity = 1,
                    price = Price.of(20000),
                )
            val order = order(orderItems = listOf(orderItem1, orderItem2))
            val couponDiscount = Price.of(5000)
            val pointsToUse = Price.of(3000)

            // when
            val finalPaymentAmount = order.calculateFinalPaymentAmount(couponDiscount, pointsToUse)

            // then
            // (10000 * 2 + 20000) - 5000 - 3000 = 32000
            finalPaymentAmount shouldBe Price.of(32000)
        }

        "쿠폰만 사용하여 최종 결제 금액을 계산한다" {
            // given
            val orderItem1 = orderItem(quantity = 2, price = Price.of(10000))
            val orderItem2 = orderItem(quantity = 1, price = Price.of(20000))
            val order = order(orderItems = listOf(orderItem1, orderItem2))
            val couponDiscount = Price.of(5000)

            // when
            val finalPaymentAmount = order.calculateFinalPaymentAmount(couponDiscount)

            // then
            // (10000 * 2 + 20000) - 5000 = 35000
            finalPaymentAmount shouldBe Price.of(35000)
        }

        "포인트만 사용하여 최종 결제 금액을 계산한다" {
            // given
            val orderItem1 = orderItem(quantity = 2, price = Price.of(10000))
            val orderItem2 = orderItem(quantity = 1, price = Price.of(20000))
            val order = order(orderItems = listOf(orderItem1, orderItem2))
            val pointsToUse = Price.of(3000)

            // when
            val finalPaymentAmount = order.calculateFinalPaymentAmount(pointsToUse = pointsToUse)

            // then
            // (10000 * 2 + 20000) - 3000 = 37000
            finalPaymentAmount shouldBe Price.of(37000)
        }

        "쿠폰과 포인트 없이 최종 결제 금액을 계산한다" {
            // given
            val orderItem1 = orderItem(quantity = 2, price = Price.of(10000))
            val orderItem2 = orderItem(quantity = 1, price = Price.of(20000))
            val order = order(orderItems = listOf(orderItem1, orderItem2))

            // when
            val finalPaymentAmount = order.calculateFinalPaymentAmount()

            // then
            // (10000 * 2 + 20000) = 40000
            finalPaymentAmount shouldBe Price.of(40000)
        }
    })
