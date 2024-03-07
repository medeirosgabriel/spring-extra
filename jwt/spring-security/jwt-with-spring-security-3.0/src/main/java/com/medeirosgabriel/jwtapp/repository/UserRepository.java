package com.medeirosgabriel.jwtapp.repository;

import com.medeirosgabriel.jwtapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> { }
