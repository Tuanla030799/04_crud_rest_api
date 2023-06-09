package com.tuna.springboot.crud_rest_api.service;

import com.tuna.springboot.crud_rest_api.entity.Employee;

import java.util.List;

public interface EmployeeService {
	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);
}
