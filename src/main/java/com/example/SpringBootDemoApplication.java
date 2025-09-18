package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Main Application
 * 
 * @SpringBootApplication does 3 things:
 * 1. @Configuration - Says this class has configuration
 * 2. @EnableAutoConfiguration - Spring Boot auto-configures beans
 * 3. @ComponentScan - Scans for @Component, @Service, @Repository, @Controller
 */
@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        System.out.println("=== Spring Boot Dependency Injection Demo ===");
        SpringApplication.run(SpringBootDemoApplication.class, args);
        System.out.println("   GET  http://localhost:8080/api/students");
        System.out.println("   POST http://localhost:8080/api/students");
        System.out.println("\n🌐 MVC Endpoints (returns HTML pages):");
        System.out.println("   GET  http://localhost:8080/mvc/students");
        System.out.println("   GET  http://localhost:8080/mvc/students/add");
    }
}