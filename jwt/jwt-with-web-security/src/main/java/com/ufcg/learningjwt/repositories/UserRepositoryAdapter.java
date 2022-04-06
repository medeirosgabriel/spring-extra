package com.ufcg.learningjwt.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ufcg.learningjwt.entities.User;


@Component
public class UserRepositoryAdapter implements UserRepositoryPort {
	
	@Autowired
	private UserRepository authRepository;

	@Override
	public User save(User user) {
		return authRepository.save(user);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return authRepository.findByEmail(email);
	}
	
	@Override
	public Optional<User> findById(Integer id){
		return authRepository.findById(id);
	}

}
