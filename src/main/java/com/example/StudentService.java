package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Student Service - Demonstrates Dependency Injection
 */
@Service
public class StudentService {

    // DEPENDENCY INJECTION - Spring automatically injects StudentRepository
    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        System.out.println("Service: Saving student - " + student.getName());
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        System.out.println("Service: Getting all students");
        return studentRepository.findAll();
    }
}