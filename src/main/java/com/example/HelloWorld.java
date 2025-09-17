package com.example;

/**
 * Hibernate Hello World Example
 */
public class HelloWorld {
    
    public static void main(String[] args) {
        System.out.println("=== Hibernate Hello World ===");
        
        try {
            StudentDAO studentDAO = new StudentDAO();
            
            // Create and save a student
            Student student = new Student("John Doe", "CS2021001", 5, "A", "Computer Science", 8.5, 8.2);
            studentDAO.saveStudent(student);
            System.out.println("Student saved: " + student.getName());

        } finally {
            HibernateUtil.shutdown();
        }
    }
}