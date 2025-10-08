package com.rockpay.order.db

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class OrderDbTestApplication

fun main(args: Array<String>) {
    runApplication<OrderDbTestApplication>(*args)
}
