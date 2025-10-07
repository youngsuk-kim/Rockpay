package com.rockpay.db.core.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = ["com.rockpay.db.core"])
@EnableJpaRepositories(basePackages = ["com.rockpay.db.core"])
internal class CoreJpaConfig
