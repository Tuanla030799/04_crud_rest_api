package com.tuna.springboot.crud_rest_api.instructor.service;

import com.tuna.springboot.crud_rest_api.instructor.entity.Instructor;

import java.util.List;

public interface InstructorService {
	List<Instructor> findAll();
	
	Instructor findById(int theId);
	
	Instructor save(Instructor theInstructor);
	
	void deleteById(int theId);
}
