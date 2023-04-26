package com.tuna.springboot.crud_rest_api.student.repository;

import com.tuna.springboot.crud_rest_api.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
