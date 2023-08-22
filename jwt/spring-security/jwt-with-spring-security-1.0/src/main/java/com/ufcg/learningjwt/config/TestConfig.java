package com.ufcg.learningjwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ufcg.learningjwt.entities.User;
import com.ufcg.learningjwt.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("1234");
		
		User u1 = new User(1, "maria@gmail.com", encodedPassword);
		User u2 = new User(2, "alex@gmail.com", encodedPassword);
		
		userRepository.save(u1);
		userRepository.save(u2);
	}
}