package com.ufcg.learningjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufcg.learningjwt.model.User;

public interface UserRepository extends JpaRepository<User, String> {}
