package com.ufcg.learningjwt.repositories;

import java.util.Optional;

import com.ufcg.learningjwt.entities.User;

public interface UserRepositoryPort {
	
	Optional<User> findById(Integer id);
	
	Optional<User> findByEmail(String email);
	
	User save(User user);

}
