package com.medeirosgabriel.jpatesting.repository;

import com.medeirosgabriel.jpatesting.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> { }
