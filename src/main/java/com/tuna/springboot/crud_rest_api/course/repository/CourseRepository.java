package com.tuna.springboot.crud_rest_api.course.repository;

import com.tuna.springboot.crud_rest_api.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
