package com.tuna.springboot.crud_rest_api.instructor.service;

import com.tuna.springboot.crud_rest_api.instructor.entity.Instructor;
import com.tuna.springboot.crud_rest_api.instructor.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {
	
	private final InstructorRepository instructorRepository;
	
	@Autowired
	public InstructorServiceImpl(InstructorRepository instructorRepository) {
		this.instructorRepository = instructorRepository;
	}
	
	@Override
	public List<Instructor> findAll() {
		return this.instructorRepository.findAll();
	}
	
	@Override
	public Instructor findById(int theId) {
		Optional<Instructor> result = instructorRepository.findById(theId);
		
		Instructor theInstructor = null;
		
		if (result.isPresent()) {
			theInstructor = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find instructor id - " + theId);
		}
		
		return theInstructor;
	}
	
	@Transactional
	@Override
	public Instructor save(Instructor theInstructor) {
		return this.instructorRepository.save(theInstructor);
	}
	
	@Transactional
	@Override
	public void deleteById(int theId) {
		this.instructorRepository.deleteById(theId);
	}
}
