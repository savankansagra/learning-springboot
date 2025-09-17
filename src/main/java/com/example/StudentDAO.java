package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple Student Data Access Object with PreparedStatements
 */
public class StudentDAO {

    /**
     * Insert a new student record
     */
    public boolean insertStudent(Student student) {
        String insertSQL = "INSERT INTO students (name, enrollment_no, semester, division, department, sgpa, cgpa) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEnrollmentNo());
            pstmt.setInt(3, student.getSemester());
            pstmt.setString(4, student.getDivision());
            pstmt.setString(5, student.getDepartment());
            pstmt.setDouble(6, student.getSgpa());
            pstmt.setDouble(7, student.getCgpa());
            
            int result = pstmt.executeUpdate();
            return result > 0;
            
        } catch (SQLException e) {
            System.err.println("Error inserting student: " + e.getMessage());
            return false;
        }
    }

    /**
     * Retrieve student by enrollment number
     */
    public Student getStudentByEnrollmentNo(String enrollmentNo) {
        String selectSQL = "SELECT * FROM students WHERE enrollment_no = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
            
            pstmt.setString(1, enrollmentNo);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEnrollmentNo(rs.getString("enrollment_no"));
                student.setSemester(rs.getInt("semester"));
                student.setDivision(rs.getString("division"));
                student.setDepartment(rs.getString("department"));
                student.setSgpa(rs.getDouble("sgpa"));
                student.setCgpa(rs.getDouble("cgpa"));
                return student;
            }
            
        } catch (SQLException e) {
            System.err.println("Error retrieving student: " + e.getMessage());
        }
        
        return null;
    }


}