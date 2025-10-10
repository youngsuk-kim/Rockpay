package com.rockpay.order.db.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class OrderDataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "database.datasource.order")
    fun orderHikariConfig(): HikariConfig = HikariConfig()

    @Bean
    fun orderDataSource(
        @Qualifier("orderHikariConfig") config: HikariConfig,
    ): HikariDataSource = HikariDataSource(config)
}
