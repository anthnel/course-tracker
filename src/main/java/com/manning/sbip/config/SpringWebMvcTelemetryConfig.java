package com.manning.sbip.config;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.instrumentation.spring.webmvc.v6_0.SpringWebMvcTelemetry;
import jakarta.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringWebMvcTelemetryConfig {

    @Bean
    public Filter telemetryFilter(OpenTelemetry openTelemetry) {
        return SpringWebMvcTelemetry.create(openTelemetry).createServletFilter();
    }
}