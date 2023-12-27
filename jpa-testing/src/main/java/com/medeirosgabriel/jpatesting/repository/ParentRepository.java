package com.medeirosgabriel.jpatesting.repository;

import com.medeirosgabriel.jpatesting.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Long> { }
