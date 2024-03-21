package com.manning.sbip;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseTrackerSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CourseTrackerSpringBootApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    // @Bean
    // public OpenTelemetry openTelemetry() {
    // OpenTelemetrySdk openTelemetry =
    // AutoConfiguredOpenTelemetrySdk.initialize().getOpenTelemetrySdk();

    // // Find OpenTelemetryAppender in logback configuration and install
    // // openTelemetrySdk
    // OpenTelemetryAppender.install(openTelemetry);

    // // Add hook to close SDK, which flushes logs
    // Runtime.getRuntime().addShutdownHook(new Thread(openTelemetry::close));

    // return openTelemetry;

    // }

}
