package com.rockpay.messaging

/**
 * 메시지 브로커의 공통 인터페이스 (Kafka, RabbitMQ 등)
 * 이벤트 기반 아키텍처에서 메시지를 송수신하는 계약을 정의합니다.
 */
interface MessageBroker {
    /**
     * 지정된 토픽/익스체인지로 메시지를 발행합니다.
     *
     * @param topic 메시지를 발행할 토픽 또는 익스체인지
     * @param message 발행할 메시지
     * @param headers 메시지에 포함할 선택적 헤더
     */
    fun publish(
        topic: String,
        message: String,
        headers: Map<String, Any> = emptyMap(),
    )

    /**
     * 지정된 토픽/익스체인지로 메시지를 발행합니다.
     *
     * @param topic 메시지를 발행할 토픽 또는 익스체인지
     * @param message 객체로 발행할 메시지 (JSON으로 직렬화됨)
     * @param headers 메시지에 포함할 선택적 헤더
     */
    fun publish(
        topic: String,
        message: Any,
        headers: Map<String, Any> = emptyMap(),
    )

    /**
     * 토픽/익스체인지를 구독하여 메시지를 수신합니다.
     *
     * @param topic 구독할 토픽 또는 익스체인지
     * @param groupId 컨슈머 그룹 ID (Kafka용) 또는 큐 이름 (RabbitMQ용)
     * @param callback 메시지 수신 시 호출될 콜백 함수
     */
    fun subscribe(
        topic: String,
        groupId: String,
        callback: (String, Map<String, Any>) -> Unit,
    )

    /**
     * 토픽/익스체인지 구독을 해제합니다.
     *
     * @param topic 구독 해제할 토픽 또는 익스체인지
     * @param groupId 컨슈머 그룹 ID (Kafka용) 또는 큐 이름 (RabbitMQ용)
     */
    fun unsubscribe(
        topic: String,
        groupId: String,
    )
}
