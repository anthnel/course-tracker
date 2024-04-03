package com.manning.sbip;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.manning.sbip.model.Course;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integration")
@Testcontainers
public class CourseTrackerSpringBootApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void whenPostRequestThenCourseCreated() {

        var course1 = new Course(null, "Rapid Spring Boot Application Development", "Spring", 4,
                "Learn Enterprise Application Development with Spring Boot");

        webTestClient
                .post()
                .uri("/addcourse")
                .bodyValue(course1)
                .exchange()
                .expectStatus().isOk();

    }

}
