package com.tuna.springboot.crud_rest_api.dao;

import com.tuna.springboot.crud_rest_api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
