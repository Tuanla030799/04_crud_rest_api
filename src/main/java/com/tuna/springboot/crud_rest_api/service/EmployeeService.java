package com.tuna.springboot.crud_rest_api.service;

import com.tuna.springboot.crud_rest_api.entity.Employee;

import java.util.List;

public interface EmployeeService {
	List<Employee> findAll();
}
