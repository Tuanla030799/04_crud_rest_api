package com.tuna.springboot.crud_rest_api.student.service;

import com.tuna.springboot.crud_rest_api.student.repository.StudentRepository;
import com.tuna.springboot.crud_rest_api.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@Override
	public List<Student> findAll() {
		return this.studentRepository.findAll();
	}
	
	@Override
	public Student findById(int theId) {
		Optional<Student> result = studentRepository.findById(theId);
		
		Student theStudent = null;
		
		if (result.isPresent()) {
			theStudent = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find student id - " + theId);
		}
		
		return theStudent;
	}
	
	@Transactional
	@Override
	public Student save(Student theStudent) {
		return this.studentRepository.save(theStudent);
	}
	
	@Transactional
	@Override
	public void deleteById(int theId) {
		this.studentRepository.deleteById(theId);
	}
}
