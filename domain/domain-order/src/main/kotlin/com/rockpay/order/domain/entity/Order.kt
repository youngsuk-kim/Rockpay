package com.rockpay.order.domain.entity

import com.rockpay.order.domain.entity.OrderItem.Companion.sumOfPrices
import com.rockpay.support.domain.Price
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "orders") // "order" is a reserved keyword in SQL
class Order(
    id: Long = 0L,
    orderStatus: OrderStatus,
    orderItems: MutableList<OrderItem> = mutableListOf(),
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = id
        private set

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    var orderStatus: OrderStatus = orderStatus
        private set

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "order_id", nullable = false)
    var orderItems: MutableList<OrderItem> = orderItems.toMutableList()
        private set

    fun markAsPaid() {
        if (this.orderStatus != OrderStatus.PENDING) {
            throw IllegalStateException("주문이 PENDING 상태일 때만 결제 완료로 변경할 수 있습니다.")
        }
        this.orderStatus = OrderStatus.PAID
    }

    fun calculateFinalPaymentAmount(
        couponDiscount: Price = Price.of(0),
        pointsToUse: Price = Price.of(0),
    ): Price {
        val totalAmount = orderItems.sumOfPrices()
        return totalAmount - couponDiscount - pointsToUse
    }

    companion object {
        fun of(orderItems: List<OrderItem>): Order = Order(orderStatus = OrderStatus.PENDING, orderItems = orderItems.toMutableList())
    }
}
