package com.manning.sbip.demo;

import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.manning.sbip.model.Course;
import com.manning.sbip.repository.CourseRepository;

@Component
@Profile("testdata")
public class CourseDataLoader {

    private final CourseRepository courseRepository;

    public CourseDataLoader(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        courseRepository.deleteAll();
        var course1 = new Course(null, "Rapid Spring Boot Application Development", "Spring", 4,
                "Learn Enterprise Application Development with Spring Boot");
        var course2 = new Course(null, "Getting Started with Spring Security DSL", "Spring", 5,
                "Learn Spring Security DSL in Easy Steps");
        var course3 = new Course(null, "Getting Started with Spring Cloud Kubernetes", "Spring", 3,
                "Master Spring Boot Application Deployment with Kubernetes");
        courseRepository.saveAll(List.of(course1, course2, course3));
    }

}