package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Simple database connection utility class
 */
public class DatabaseConnection {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/learningspringboot";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "";

    /**
     * Get database connection
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    /**
     * Create student table if it doesn't exist
     */
    public static void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS students (" +
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR(100) NOT NULL, " +
                "enrollment_no VARCHAR(50) UNIQUE NOT NULL, " +
                "semester INT NOT NULL, " +
                "division VARCHAR(10) NOT NULL, " +
                "department VARCHAR(50) NOT NULL, " +
                "sgpa DECIMAL(4,2) NOT NULL, " +
                "cgpa DECIMAL(4,2) NOT NULL" +
                ")";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            
            stmt.execute(createTableSQL);
            System.out.println("Table created successfully!");
            
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }
}