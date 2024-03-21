package com.manning.sbip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manning.sbip.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

}
