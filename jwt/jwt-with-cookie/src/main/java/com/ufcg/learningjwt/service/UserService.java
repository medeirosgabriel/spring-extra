package com.ufcg.learningjwt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.learningjwt.model.User;
import com.ufcg.learningjwt.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User insertUser(User user) {
		return userRepository.save(user);
	}
	
	public Optional<User> findUserById(String email) {
		return userRepository.findById(email);
	}
}
