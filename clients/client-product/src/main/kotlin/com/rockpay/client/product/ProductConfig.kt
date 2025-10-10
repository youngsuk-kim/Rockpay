package com.rockpay.client.product

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@EnableFeignClients(basePackages = ["com.rockpay.client.product"])
@ComponentScan(basePackages = ["com.rockpay.client.product"])
@Configuration
class ProductConfig
