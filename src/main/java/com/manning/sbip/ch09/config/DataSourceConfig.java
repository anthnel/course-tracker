package com.manning.sbip.ch09.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.instrumentation.jdbc.datasource.JdbcTelemetry;

@Configuration
public class DataSourceConfig {

    @Autowired
    private OpenTelemetry openTelemetry;

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:sbipdb");

        return JdbcTelemetry.create(openTelemetry).wrap(dataSourceBuilder.build());
    }

}
