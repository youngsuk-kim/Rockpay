package com.rockpay.messaging.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.rockpay.messaging.MessageBroker
import com.rockpay.messaging.kafka.KafkaMessageBroker
import com.rockpay.messaging.rabbitmq.RabbitMQMessageBroker
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

/**
 * 메시징 설정
 */
@Configuration
@ComponentScan(basePackages = ["com.rockpay.messaging"])
@EnableConfigurationProperties(MessagingProperties::class)
class MessagingConfig {
    /**
     * 설정된 타입에 따라 MessageBroker 빈을 생성합니다.
     */
    @Bean
    @ConditionalOnProperty(name = ["rockpay.messaging.type"], havingValue = "kafka")
    fun kafkaMessageBroker(
        kafkaTemplate: KafkaTemplate<String, String>,
        kafkaConsumerFactory: ConsumerFactory<String, String>,
        objectMapper: ObjectMapper,
    ): MessageBroker = KafkaMessageBroker(kafkaTemplate, kafkaConsumerFactory, objectMapper)

    @Bean
    @ConditionalOnProperty(name = ["rockpay.messaging.type"], havingValue = "rabbitmq")
    fun rabbitMQMessageBroker(
        rabbitTemplate: RabbitTemplate,
        connectionFactory: ConnectionFactory,
        objectMapper: ObjectMapper,
    ): MessageBroker = RabbitMQMessageBroker(rabbitTemplate, connectionFactory, objectMapper)

    /**
     * Kafka 프로듀서 팩토리
     */
    @Bean
    fun kafkaProducerFactory(messagingProperties: MessagingProperties): ProducerFactory<String, String> {
        val configProps = HashMap<String, Any>()
        configProps[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = messagingProperties.kafka.bootstrapServers
        configProps[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        configProps[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        return DefaultKafkaProducerFactory(configProps)
    }

    /**
     * Kafka 템플릿
     */
    @Bean
    fun kafkaTemplate(producerFactory: ProducerFactory<String, String>): KafkaTemplate<String, String> = KafkaTemplate(producerFactory)

    /**
     * Kafka 컨슈머 팩토리
     */
    @Bean
    fun kafkaConsumerFactory(messagingProperties: MessagingProperties): ConsumerFactory<String, String> {
        val configProps = HashMap<String, Any>()
        configProps[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = messagingProperties.kafka.bootstrapServers
        configProps[ConsumerConfig.GROUP_ID_CONFIG] = messagingProperties.kafka.consumerGroupId
        configProps[ConsumerConfig.AUTO_OFFSET_RESET_CONFIG] = messagingProperties.kafka.autoOffsetReset
        configProps[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        configProps[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        return DefaultKafkaConsumerFactory(configProps)
    }

    /**
     * RabbitMQ 커넥션 팩토리
     */
    @Bean
    fun rabbitConnectionFactory(messagingProperties: MessagingProperties): ConnectionFactory =
        CachingConnectionFactory().apply {
            setHost(messagingProperties.rabbitmq.host)
            setPort(messagingProperties.rabbitmq.port)
            setUsername(messagingProperties.rabbitmq.username)
            setPassword(messagingProperties.rabbitmq.password)
            setVirtualHost(messagingProperties.rabbitmq.virtualHost)
        }

    /**
     * RabbitMQ 템플릿
     */
    @Bean
    fun rabbitTemplate(connectionFactory: ConnectionFactory): RabbitTemplate = RabbitTemplate(connectionFactory)
}
