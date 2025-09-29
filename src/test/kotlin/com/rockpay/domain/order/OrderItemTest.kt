package com.rockpay.domain.order

import com.rockpay.domain.common.Price
import com.rockpay.domain.order.OrderItem.Companion.sumOfPrices
import com.rockpay.fixture.order.orderItem
import com.rockpay.fixture.product.product
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OrderItemTest : StringSpec({

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
        val orderItem = orderItem(status = OrderItemStatus.PAID, delivery = Delivery(status = DeliveryStatus.PENDING))

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

    "상품과 수량으로 주문 아이템을 생성한다" {
        // given
        val product = product(basePrice = 10000, discountAmount = 2000)
        val quantity = 2

        // when
        val orderItem = orderItem(product = product, quantity = quantity)

        // then
        orderItem.productId shouldBe product.id
        orderItem.quantity shouldBe quantity
        orderItem.price shouldBe Price.of(16000) // (10000 - 2000) * 2
        orderItem.status shouldBe OrderItemStatus.PAID
    }

    "주문 아이템 목록의 총 가격을 계산한다" {
        // given
        val orderItem1 = orderItem(product = product(basePrice = 10000))
        val orderItem2 = orderItem(product = product(basePrice = 20000), quantity = 2)
        val orderItems = listOf(orderItem1, orderItem2)

        // when
        val totalPrice = orderItems.sumOfPrices()

        // then
        totalPrice shouldBe Price.of(50000)
    }
})
