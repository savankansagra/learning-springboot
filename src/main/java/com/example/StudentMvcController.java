package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * MVC Controller - Demonstrates Spring MVC Pattern with ModelAndView
 * 
 * KEY DIFFERENCES from REST Controller:
 * - @Controller (not @RestController) 
 * - Returns ModelAndView or view names (not data)
 * - ModelAndView combines both Model and View in one object
 */
@Controller
@RequestMapping("/mvc/students")
public class StudentMvcController {

    // DEPENDENCY INJECTION - Same service as REST controller
    @Autowired
    private StudentService studentService;

    // GET /mvc/students - Shows all students using ModelAndView
    @GetMapping
    public ModelAndView showAllStudents() {
        System.out.println("MVC Controller: GET request - using ModelAndView");
        
        // ModelAndView = Model + View combined in one object
        ModelAndView modelAndView = new ModelAndView();
        
        // Set VIEW name
        modelAndView.setViewName("students-list");
        
        // Add MODEL data
        modelAndView.addObject("students", studentService.getAllStudents());
        modelAndView.addObject("title", "All Students");
        
        return modelAndView;  // Returns both view name and data together
    }

    // GET /mvc/students/add - Shows form using ModelAndView
    @GetMapping("/add")
    public ModelAndView showAddForm() {
        System.out.println("MVC Controller: Showing add form - using ModelAndView");
        
        // Constructor with view name - shortcut approach
        ModelAndView modelAndView = new ModelAndView("student-form");
        
        // Add MODEL data for form binding
        modelAndView.addObject("student", new Student());
        modelAndView.addObject("title", "Add Student");
        
        return modelAndView;
    }

    // POST /mvc/students/add - Still uses simple redirect (no view needed)
    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        System.out.println("MVC Controller: Form submitted - saving student");
        
        // CONTROLLER - Process the form data
        studentService.saveStudent(student);
        
        // REDIRECT - Simple redirect, no need for ModelAndView
        return "redirect:/mvc/students";
    }
}