package com.rockpay.order.domain.entity

import com.rockpay.support.domain.Price
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "order_item")
class OrderItem(
    id: Long = 0L,
    productId: Long = 0L,
    quantity: Int,
    price: Price,
    status: OrderItemStatus,
    delivery: Delivery,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = id
        private set

    @Column(name = "product_id")
    var productId = productId
        private set

    @Column(name = "quantity")
    var quantity: Int = quantity
        private set

    @Column(name = "price")
    var price: Price = price
        private set

    @Column(name = "status")
    var status: OrderItemStatus = status
        private set

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "delivery_id")
    var delivery: Delivery = delivery
        private set

    fun getTotalPrice(): Price = price * quantity

    fun markAsReturnRequest() {
        this.status = OrderItemStatus.RETURN_REQUEST
    }

    fun ship() {
        require(this.status == OrderItemStatus.PAID) { "결제가 완료 되어야 배송이 가능 합니다" }

        this.delivery.markAsShipped()
    }

    companion object {
        fun of(
            productId: Long,
            quantity: Int,
            price: Price,
            status: OrderItemStatus,
            delivery: Delivery,
        ): OrderItem =
            OrderItem(
                productId = productId,
                quantity = quantity,
                price = price,
                status = status,
                delivery = delivery,
            )

        /**
         * 상품 ID 목록, 수량 목록, 가격 목록으로 주문 항목 목록을 생성하는 메서드
         */
        fun createOrderItems(
            productIds: List<Long>,
            quantities: List<Int>,
            prices: List<Price>,
        ): List<OrderItem> =
            productIds.mapIndexed { index, productId ->
                // 각 상품에 대한 배송 정보를 생성합니다
                val delivery = Delivery.of()

                // 상품 정보와 수량으로 주문 항목을 생성합니다
                of(
                    productId = productId,
                    quantity = quantities[index],
                    price = prices[index],
                    status = OrderItemStatus.PENDING,
                    delivery = delivery,
                )
            }

        fun List<OrderItem>.sumOfPrices(): Price = this.fold(Price.of()) { acc, orderItem -> acc + orderItem.getTotalPrice() }
    }
}
