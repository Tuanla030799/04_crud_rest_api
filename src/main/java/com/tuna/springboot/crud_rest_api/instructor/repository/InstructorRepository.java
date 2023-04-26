package com.tuna.springboot.crud_rest_api.instructor.repository;

import com.tuna.springboot.crud_rest_api.instructor.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
}
