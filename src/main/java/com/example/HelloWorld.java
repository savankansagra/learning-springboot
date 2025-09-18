package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hibernate Lazy vs Eager Loading Demo for College Students
 */
public class HelloWorld {
    
    public static void main(String[] args) {
        try {
            // Setup data
            saveStudent();
            demonstrateLazyLoading();
            System.out.println("\n" + "-".repeat(40) + "\n");
            demonstrateEagerLoading();
        } finally {
            HibernateUtil.shutdown();
        }
    }
    
    private static void saveStudent() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Student student = new Student("John Doe", "CS001", 3, "A", "Computer Science", 8.5, 8.0);
            session.persist(student);
            tx.commit();
        }
    }
    
    // LAZY LOADING - session.load() creates proxy, SQL fired when accessed
    private static void demonstrateLazyLoading() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student student = session.load(Student.class, 1);// Proxy created
            System.out.println("   Name: " + student.getName());  // SQL executed here
        }
    }
    
    // EAGER LOADING - session.get() fires SQL immediately
    private static void demonstrateEagerLoading() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student student = session.get(Student.class, 1);  // SQL executed immediately
            System.out.println("   Name: " + student.getName());  // No SQL, data cached
        }
    }
}