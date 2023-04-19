package com.tuna.springboot.crud_rest_api.employee.rest;

import com.tuna.springboot.crud_rest_api.employee.entity.Employee;
import com.tuna.springboot.crud_rest_api.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	// add mapping for GET /employees/{employeeId}
	@GetMapping("employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found -" + employeeId);
		}
		
		return theEmployee;
	}
	
	// add mapping for POST /employees - add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		
		return this.employeeService.save(theEmployee);
	}
	
	// add mapping for PUT /employees - update existing employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		return this.employeeService.save(theEmployee);
	}
	
	// delete mapping for DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee tempEmployee = this.employeeService.findById(employeeId);
		
		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found" + employeeId);
		}
		
		this.employeeService.deleteById(employeeId);
		
		return "Delete employee id -" + employeeId;
	}
}
