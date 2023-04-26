package com.tuna.springboot.crud_rest_api.course.service;


import com.tuna.springboot.crud_rest_api.course.entity.Course;

import java.util.List;

public interface CourseService {
	List<Course> findAll();
	
	Course findById(int theId);
	
	Course save(Course theCourse);
	
	void deleteById(int theId);
}
