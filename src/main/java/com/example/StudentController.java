package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Student REST Controller - Demonstrates Dependency Injection
 */
@RestController
@RequestMapping("/api/students")
public class StudentController {

    // DEPENDENCY INJECTION - Spring automatically injects StudentService
    @Autowired
    private StudentService studentService;

    // GET /api/students - Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        System.out.println("Controller: GET request received");
        return studentService.getAllStudents();
    }

    // POST /api/students - Create a new student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        System.out.println("Controller: POST request received");
        return studentService.saveStudent(student);
    }
}