package com.rockpay.order.app.config

import com.rockpay.client.product.ProductConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(ProductConfig::class)
@ComponentScan(basePackages = ["com.rockpay.client.product"])
class ClientConfig
