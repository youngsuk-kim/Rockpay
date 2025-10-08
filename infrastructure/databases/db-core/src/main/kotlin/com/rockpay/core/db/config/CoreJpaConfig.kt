package com.rockpay.core.db.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = ["com.rockpay.core.db.repository"])
@EntityScan(basePackages = ["com.rockpay.core.domain.entity"])
internal class CoreJpaConfig
