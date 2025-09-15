package com.rockpay

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RockPayApplication

fun main(args: Array<String>) {
    runApplication<RockPayApplication>(*args)
}
