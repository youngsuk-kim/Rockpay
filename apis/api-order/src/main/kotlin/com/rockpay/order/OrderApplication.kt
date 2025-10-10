package com.rockpay.order

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@ConfigurationPropertiesScan
@SpringBootApplication
@ComponentScan(
    basePackages = [
        "com.rockpay.order",
        "com.rockpay.messaging",
    ],
)
class OrderApplication

fun main(args: Array<String>) {
    runApplication<OrderApplication>(*args)
}
