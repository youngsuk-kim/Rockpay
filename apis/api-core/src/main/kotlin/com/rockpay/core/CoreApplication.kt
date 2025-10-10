package com.rockpay.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication(
    scanBasePackages = [
        "com.rockpay.core",
        "com.rockpay.messaging",
    ],
)
class CoreApplication

fun main(args: Array<String>) {
    runApplication<CoreApplication>(*args)
}
