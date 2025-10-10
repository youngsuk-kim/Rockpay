package com.rockpay.order.app

import com.rockpay.client.product.ProductClient
import com.rockpay.order.domain.entity.Order
import com.rockpay.order.domain.repository.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateOrderService(
    private val orderRepository: OrderRepository,
    private val productClient: ProductClient,
    private val orderItemFactory: OrderItemFactory,
    private val orderCreationEventPublisher: OrderCreationEventPublisher,
) : CreateOrderUseCase {
    @Transactional
    override fun invoke(command: CreateOrderCommand): CreatedOrder {
        // 상품 클라이언트를 통해 여러 상품 정보를 가져옵니다
        val products = productClient.getProducts(command.productIds)

        // 주문 항목 목록을 생성합니다
        val orderItems = orderItemFactory.createFrom(products, command.quantities)

        // 주문 항목 목록으로 주문을 생성합니다
        val order = Order.of(orderItems)

        // 주문을 저장소에 저장하고 ID를 가져옵니다
        val savedOrder = orderRepository.save(order)

        // 트랜잭션 커밋 후 이벤트 발행
        orderCreationEventPublisher.publish(savedOrder)

        return CreatedOrder(savedOrder.id)
    }
}
