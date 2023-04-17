package com.tuna.springboot.crud_rest_api.service;

import com.tuna.springboot.crud_rest_api.dao.EmployeeDAO;
import com.tuna.springboot.crud_rest_api.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Override
	public Employee findById(int theId) {
		return this.employeeDAO.findById(theId);
	}
	
	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		return this.employeeDAO.save(theEmployee);
	}
	
	@Transactional
	@Override
	public void deleteById(int theId) {
		this.employeeDAO.deleteById(theId);
	}
}
