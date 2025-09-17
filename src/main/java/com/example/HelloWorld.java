package com.example;

import java.util.List;

/**
 * Student Management System Demo
 */
public class HelloWorld {
    
    public static void main(String[] args) {
        System.out.println("=== Student Management System ===");
        
        // Create database table
        DatabaseConnection.createTable();
        
        // Create DAO instance
        StudentDAO studentDAO = new StudentDAO();
        
        System.out.println("\n1. Adding sample students...");
        
        // Add sample students
        Student student1 = new Student("John Doe", "CS2021001", 5, "A", "Computer Science", 8.5, 8.2);
        Student student2 = new Student("Jane Smith", "CS2021002", 5, "A", "Computer Science", 9.0, 8.8);
        
        // Insert students
        if (studentDAO.insertStudent(student1)) {
            System.out.println("✓ Added: " + student1.getName());
        }
        if (studentDAO.insertStudent(student2)) {
            System.out.println("✓ Added: " + student2.getName());
        }

        System.out.println("\n=== Demo Complete ===");
    }
}