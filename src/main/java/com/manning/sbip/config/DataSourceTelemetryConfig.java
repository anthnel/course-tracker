package com.manning.sbip.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.opentelemetry.api.OpenTelemetry;
// import io.opentelemetry.instrumentation.jdbc.datasource.JdbcTelemetry;

@Configuration
public class DataSourceTelemetryConfig {

    // @Bean
    // public DataSource dataSource(OpenTelemetry openTelemetry) {
    // DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
    // dataSourceBuilder.driverClassName("org.h2.Driver");
    // dataSourceBuilder.url("jdbc:h2:mem:sbipdb");

    // return JdbcTelemetry.create(openTelemetry).wrap(dataSourceBuilder.build());
    // }

}
