package com.example.implementastudentskillstrackerapi.repository;

import com.example.implementastudentskillstrackerapi.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    boolean existsByEmail(String email);
}