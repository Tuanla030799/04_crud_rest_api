package com.tuna.springboot.crud_rest_api.employee.repository;

import com.tuna.springboot.crud_rest_api.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
