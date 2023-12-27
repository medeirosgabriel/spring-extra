package com.medeirosgabriel.jpatesting.repository;

import com.medeirosgabriel.jpatesting.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<Sport, Long> { }
