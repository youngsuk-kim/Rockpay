package com.rockpay.api.order

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication(scanBasePackages = ["com.rockpay.api.order"])
class OrderApplication

fun main(args: Array<String>) {
    runApplication<OrderApplication>(*args)
}
