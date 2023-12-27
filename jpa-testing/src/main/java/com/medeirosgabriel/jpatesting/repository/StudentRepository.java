package com.medeirosgabriel.jpatesting.repository;

import com.medeirosgabriel.jpatesting.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> { }
