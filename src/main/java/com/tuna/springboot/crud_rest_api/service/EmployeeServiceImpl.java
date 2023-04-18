package com.tuna.springboot.crud_rest_api.service;

import com.tuna.springboot.crud_rest_api.dao.EmployeeRepository;
import com.tuna.springboot.crud_rest_api.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return this.employeeRepository.findAll();
	}
	
	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}
	
	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		return this.employeeRepository.save(theEmployee);
	}
	
	@Transactional
	@Override
	public void deleteById(int theId) {
		this.employeeRepository.deleteById(theId);
	}
}
