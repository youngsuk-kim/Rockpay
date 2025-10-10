package com.rockpay.order.db.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = ["com.rockpay.order.domain.entity"])
@EnableJpaRepositories(basePackages = ["com.rockpay.order.db.repository"])
internal class OrderJpaConfig
