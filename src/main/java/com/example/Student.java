package com.example;

import jakarta.persistence.*;

/**
 * Student entity class with Hibernate annotations
 */
@ Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String enrollmentNo;

    private int semester;

    @Column(name = "division", nullable = false, length = 10)
    private String division;

    @Column(name = "department", nullable = false, length = 50)
    private String department;

    @Column(name = "sgpa", nullable = false)
    private double sgpa;

    @Column(name = "cgpa", nullable = false)
    private double cgpa;

//    private String temp;

    // Default constructor
    public Student() {}

    // Constructor with all fields
    public Student(String name, String enrollmentNo, int semester, String division,
                   String department, double sgpa, double cgpa) {
        this.name = name;
        this.enrollmentNo = enrollmentNo;
        this.semester = semester;
        this.division = division;
        this.department = department;
        this.sgpa = sgpa;
        this.cgpa = cgpa;
//
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEnrollmentNo() { return enrollmentNo; }
    public void setEnrollmentNo(String enrollmentNo) { this.enrollmentNo = enrollmentNo; }

    public int getSemester() { return semester; }
    public void setSemester(int semester) { this.semester = semester; }

    public String getDivision() { return division; }
    public void setDivision(String division) { this.division = division; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getSgpa() { return sgpa; }
    public void setSgpa(double sgpa) { this.sgpa = sgpa; }

    public double getCgpa() { return cgpa; }
    public void setCgpa(double cgpa) { this.cgpa = cgpa; }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enrollmentNo='" + enrollmentNo + '\'' +
                ", semester=" + semester +
                ", division='" + division + '\'' +
                ", department='" + department + '\'' +
                ", sgpa=" + sgpa +
                ", cgpa=" + cgpa +
                '}';
    }
}