package com.rockpay.messaging.config

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * 메시징 설정 속성
 */
@ConfigurationProperties(prefix = "rockpay.messaging")
data class MessagingProperties(
    /**
     * 사용할 메시지 브로커 타입 (kafka 또는 rabbitmq)
     */
    val type: String = "kafka",
    /**
     * Kafka 설정 속성
     */
    val kafka: KafkaProperties = KafkaProperties(),
    /**
     * RabbitMQ 설정 속성
     */
    val rabbitmq: RabbitMQProperties = RabbitMQProperties(),
)

/**
 * Kafka 설정 속성
 */
data class KafkaProperties(
    /**
     * 부트스트랩 서버
     */
    val bootstrapServers: String = "localhost:9092",
    /**
     * 컨슈머 그룹 ID
     */
    val consumerGroupId: String = "rockpay-consumer",
    /**
     * 자동 오프셋 리셋
     */
    val autoOffsetReset: String = "earliest",
)

/**
 * RabbitMQ 설정 속성
 */
data class RabbitMQProperties(
    /**
     * 호스트
     */
    val host: String = "localhost",
    /**
     * 포트
     */
    val port: Int = 5672,
    /**
     * 사용자명
     */
    val username: String = "guest",
    /**
     * 비밀번호
     */
    val password: String = "guest",
    /**
     * 가상 호스트
     */
    val virtualHost: String = "/",
)
