package com.tuna.springboot.crud_rest_api.course.rest;

import com.tuna.springboot.crud_rest_api.course.entity.Course;
import com.tuna.springboot.crud_rest_api.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {
	private final CourseService courseService;
	
	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@GetMapping("/courses")
	public List<Course> findAll() {
		return this.courseService.findAll();
	}
	
	@GetMapping("/courses/{courseId}")
	public Course findById(@PathVariable int courseId) {
		Course theCourse = this.courseService.findById(courseId);
		
		if (theCourse == null) {
			throw new RuntimeException("Course id not found -" + courseId);
		}
		
		return theCourse;
	}
	
	@PostMapping("/courses")
	public Course addBook(@RequestBody Course theCourse) {
		theCourse.setId(0);
		
		return this.courseService.save(theCourse);
	}
	
	@PutMapping("/courses")
	public Course updateBook(@RequestBody Course theCourse) {
		return this.courseService.save(theCourse);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public String deleteBook(@PathVariable int courseId) {
		Course tempCourse = this.courseService.findById(courseId);
		
		if (tempCourse == null) {
			throw new RuntimeException("course id not found" + courseId);
		}
		
		this.courseService.deleteById(courseId);
		
		return "Delete course id -" + courseId;
	}
}
