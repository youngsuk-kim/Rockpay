package com.rockpay.order.app

import com.rockpay.client.product.model.ProductClientResult
import com.rockpay.order.domain.entity.OrderItem
import org.springframework.stereotype.Component

@Component
class OrderItemFactory {
    fun createFrom(
        products: List<ProductClientResult>,
        quantities: List<Int>,
    ): List<OrderItem> {
        // 상품 ID 목록과 가격 목록을 추출합니다
        val productIds = products.map { it.id }
        val prices = products.map { it.salePrice }

        // OrderItem의 정적 팩토리 메서드를 호출하여 생성합니다
        return OrderItem.createOrderItems(productIds, quantities, prices)
    }
}
