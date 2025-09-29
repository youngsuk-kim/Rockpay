package com.rockpay.order

import com.rockpay.common.enums.order.DeliveryStatus
import com.rockpay.common.enums.order.OrderItemStatus
import com.rockpay.common.vo.Id
import com.rockpay.common.vo.Price
import com.rockpay.order.domain.entity.Delivery
import com.rockpay.order.domain.entity.OrderItem.Companion.sumOfPrices
import com.rockpay.order.fixture.orderItem
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OrderItemTest :
    StringSpec({

        "주문 아이템을 반품 요청 상태로 변경한다" {
            // given
            val orderItem = orderItem(status = OrderItemStatus.PAID)

            // when
            orderItem.markAsReturnRequest()

            // then
            orderItem.status shouldBe OrderItemStatus.RETURN_REQUEST
        }

        "결제 완료된 주문 아이템을 배송 처리한다" {
            // given
            val orderItem =
                orderItem(
                    status = OrderItemStatus.PAID,
                    delivery = Delivery.of(status = DeliveryStatus.PENDING),
                )

            // when
            orderItem.ship()

            // then
            orderItem.delivery.status shouldBe DeliveryStatus.SHIPPED
        }

        "결제 완료되지 않은 주문 아이템을 배송 처리하면 예외가 발생한다" {
            // given
            val orderItem = orderItem(status = OrderItemStatus.PENDING)

            // when, then
            shouldThrow<IllegalArgumentException> {
                orderItem.ship()
            }
        }

        "상품과 수량으로 주문 아이템을 생성하고 총액을 계산한다" {
            // given
            val productId = Id.ofExternal(1L)
            val quantity = 2
            val unitPrice = Price.of(8000)

            // when
            val orderItem =
                orderItem(
                    productId = productId,
                    quantity = quantity,
                    price = unitPrice, // 단가
                    status = OrderItemStatus.PAID,
                )

            // then
            orderItem.productId shouldBe productId
            orderItem.quantity shouldBe quantity
            orderItem.price shouldBe unitPrice
            orderItem.getTotalPrice() shouldBe Price.of(16000) // 단가 * 수량
        }

        "주문 아이템 목록의 총 가격을 계산한다" {
            // given
            val orderItem1 = orderItem(price = Price.of(10000), quantity = 1)
            val orderItem2 = orderItem(price = Price.of(20000), quantity = 2)
            val orderItems = listOf(orderItem1, orderItem2)

            // when
            val totalPrice = orderItems.sumOfPrices()

            // then
            // (10000 * 1) + (20000 * 2) = 50000
            totalPrice shouldBe Price.of(50000)
        }
    })
