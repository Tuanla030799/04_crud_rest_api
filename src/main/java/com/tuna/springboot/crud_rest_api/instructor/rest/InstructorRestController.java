package com.tuna.springboot.crud_rest_api.instructor.rest;

import com.tuna.springboot.crud_rest_api.instructor.entity.Instructor;
import com.tuna.springboot.crud_rest_api.instructor.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorRestController {
	private final InstructorService instructorService;
	
	@Autowired
	public InstructorRestController(InstructorService instructorService) {
		this.instructorService = instructorService;
	}
	
	@GetMapping("/instructors")
	public List<Instructor> findAll() {
		return instructorService.findAll();
	}
	
	// add mapping for GET /instructors/{instructorId}
	@GetMapping("/instructors/{instructorId}")
	public Instructor getEmployeeById(@PathVariable int instructorId) {
		Instructor theInstructor = instructorService.findById(instructorId);
		
		if (theInstructor == null) {
			throw new RuntimeException("instructors id not found -" + instructorId);
		}
		
		return theInstructor;
	}
	
	// add mapping for POST /instructors - add new students
	@PostMapping("/instructors")
	public Instructor addEmployee(@RequestBody Instructor theInstructor) {
		theInstructor.setId(0);
		
		return this.instructorService.save(theInstructor);
	}
	
	// add mapping for PUT /instructors - update existing instructors
	@PutMapping("/instructors")
	public Instructor updateEmployee(@RequestBody Instructor theInstructor) {
		return this.instructorService.save(theInstructor);
	}
	
	// delete mapping for DELETE /instructors/{instructorId} - delete instructors
	
	@DeleteMapping("/instructors/{instructorId}")
	public String deleteEmployee(@PathVariable int instructorId) {
		Instructor tempInstructor = this.instructorService.findById(instructorId);
		
		if (tempInstructor == null) {
			throw new RuntimeException("Instructor id not found" + instructorId);
		}
		
		this.instructorService.deleteById(instructorId);
		
		return "Delete student id -" + instructorId;
	}
}
