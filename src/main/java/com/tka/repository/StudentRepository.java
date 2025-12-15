package com.tka.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tka.Entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    // Find student by email (unique field)
    Optional<StudentEntity> findByEmail(String email);

    // Find students by course
    List<StudentEntity> findByCourse(String course);

    // Find students whose name contains keyword (case-insensitive)
    List<StudentEntity> findByNameContainingIgnoreCase(String name);

    // Check if email already exists (for validation)
    boolean existsByEmail(String email);
}
