package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Student Repository - Spring Data JPA automatically provides CRUD operations
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Spring Data JPA automatically implements:
    // - save()
    // - findById()
    // - findAll()
    // - delete()
    // No need to write any code!
}