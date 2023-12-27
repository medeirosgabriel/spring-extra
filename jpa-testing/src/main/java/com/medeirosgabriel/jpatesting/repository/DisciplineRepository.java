package com.medeirosgabriel.jpatesting.repository;

import com.medeirosgabriel.jpatesting.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> { }
