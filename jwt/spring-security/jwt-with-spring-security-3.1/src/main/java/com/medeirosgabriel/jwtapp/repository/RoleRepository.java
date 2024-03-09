package com.medeirosgabriel.jwtapp.repository;

import com.medeirosgabriel.jwtapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {}
