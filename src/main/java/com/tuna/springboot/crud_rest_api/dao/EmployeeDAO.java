package com.tuna.springboot.crud_rest_api.dao;

import com.tuna.springboot.crud_rest_api.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
	List<Employee> findAll();
}
