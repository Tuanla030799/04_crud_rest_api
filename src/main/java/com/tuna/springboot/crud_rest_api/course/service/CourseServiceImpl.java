package com.tuna.springboot.crud_rest_api.course.service;

import com.tuna.springboot.crud_rest_api.course.entity.Course;
import com.tuna.springboot.crud_rest_api.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
	
	private final CourseRepository courseRepository;
	
	@Autowired
	public CourseServiceImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	@Override
	public List<Course> findAll() {
		return this.courseRepository.findAll();
	}
	
	@Override
	public Course findById(int theId) {
		Optional<Course> result = this.courseRepository.findById(theId);
		
		Course theCourse = null;
		
		if (result.isPresent()) {
			theCourse = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find course id - " + theId);
		}
		
		return theCourse;
	}
	
	@Override
	public Course save(Course theCourse) {
		return this.courseRepository.save(theCourse);
	}
	
	@Override
	public void deleteById(int theId) {
		this.courseRepository.deleteById(theId);
	}
}
