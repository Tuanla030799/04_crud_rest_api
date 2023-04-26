package com.tuna.springboot.crud_rest_api.student.rest;

import com.tuna.springboot.crud_rest_api.student.entity.Student;
import com.tuna.springboot.crud_rest_api.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private final StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    // add mapping for GET /students/{studentId}
    @GetMapping("/students/{studentId}")
    public Student getEmployeeById(@PathVariable int studentId) {
        Student theStudent = studentService.findById(studentId);

        if (theStudent == null) {
            throw new RuntimeException("students id not found -" + studentId);
        }

        return theStudent;
    }

    // add mapping for POST /students - add new students
    @PostMapping("/students")
    public Student addEmployee(@RequestBody Student theStudent) {
        theStudent.setId(0);

        return this.studentService.save(theStudent);
    }

    // add mapping for PUT /students - update existing students
    @PutMapping("/students")
    public Student updateEmployee(@RequestBody Student theEmployee) {
        return this.studentService.save(theEmployee);
    }

    // delete mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/students/{studentId}")
    public String deleteEmployee(@PathVariable int studentId) {
        Student tempStudent = this.studentService.findById(studentId);

        if (tempStudent == null) {
            throw new RuntimeException("Student id not found" + studentId);
        }

        this.studentService.deleteById(studentId);

        return "Delete student id -" + studentId;
    }
}
