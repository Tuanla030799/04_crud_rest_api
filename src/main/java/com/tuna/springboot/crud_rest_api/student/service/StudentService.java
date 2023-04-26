package com.tuna.springboot.crud_rest_api.student.service;

import com.tuna.springboot.crud_rest_api.student.entity.Student;

import java.util.List;

public interface StudentService {
	List<Student> findAll();
	
	Student findById(int theId);
	
	Student save(Student theStudent);
	
	void deleteById(int theId);
}
