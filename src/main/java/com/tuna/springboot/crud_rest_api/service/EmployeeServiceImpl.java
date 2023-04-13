package com.tuna.springboot.crud_rest_api.service;

import com.tuna.springboot.crud_rest_api.dao.EmployeeDAO;
import com.tuna.springboot.crud_rest_api.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		this.employeeDAO = theEmployeeDAO;
	}
	
	@Override
	public List<Employee> findAll() {
		return this.employeeDAO.findAll();
	}
}
