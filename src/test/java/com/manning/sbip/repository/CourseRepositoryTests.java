package com.manning.sbip.repository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import com.manning.sbip.model.Course;
import com.manning.sbip.service.DefaultCourseService;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(DefaultCourseService.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration")
public class CourseRepositoryTests {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void findAllCourses() {
        var course1 = new Course(null, "Rapid Spring Boot Application Development", "Spring", 4,
                "Learn Enterprise Application Development with Spring Boot");
        var course2 = new Course(null, "Getting Started with Spring Security DSL", "Spring", 5,
                "Learn Spring Security DSL in Easy Steps");

        courseRepository.save(course1);
        courseRepository.save(course2);

        Iterable<Course> actualCourses = courseRepository.findAll();

        assertThat(StreamSupport.stream(actualCourses.spliterator(), true)
                .filter(course -> course.getName().equals(course1.getName())
                        || course.getName().equals(course2.getName()))
                .collect(Collectors.toList())).hasSize(2);
    }

    @Test
    void findByIdWhenExisting() {
        var course1 = new Course(1L, "Rapid Spring Boot Application Development", "Spring", 4,
                "Learn Enterprise Application Development with Spring Boot");
        var course2 = new Course(2L, "Getting Started with Spring Security DSL", "Spring", 5,
                "Learn Spring Security DSL in Easy Steps");

        courseRepository.save(course1);
        courseRepository.save(course2);

        var actualCourse = courseRepository.findById(1L);

        assertThat(actualCourse).isPresent();
        assertThat(actualCourse.get().getId()).isEqualTo(course1.getId());
    }

    @Test
    void findByIdWhenNotExisting() {
        var course1 = new Course(1L, "Rapid Spring Boot Application Development", "Spring", 4,
                "Learn Enterprise Application Development with Spring Boot");
        var course2 = new Course(2L, "Getting Started with Spring Security DSL", "Spring", 5,
                "Learn Spring Security DSL in Easy Steps");

        courseRepository.save(course1);
        courseRepository.save(course2);

        var actualCourse = courseRepository.findById(3L);

        assertThat(actualCourse).isNotPresent();
    }

    @Test
    void deleteCourseById() {
        var course1 = new Course(1L, "Rapid Spring Boot Application Development", "Spring", 4,
                "Learn Enterprise Application Development with Spring Boot");
        var course2 = new Course(2L, "Getting Started with Spring Security DSL", "Spring", 5,
                "Learn Spring Security DSL in Easy Steps");

        courseRepository.save(course1);
        courseRepository.save(course2);

        courseRepository.deleteById(1L);

        Iterable<Course> actualCourses = courseRepository.findAll();

        assertThat(StreamSupport.stream(actualCourses.spliterator(), true)
                .filter(course -> course.getName().equals(course2.getName()))
                .collect(Collectors.toList())).hasSize(1);

    }

}
