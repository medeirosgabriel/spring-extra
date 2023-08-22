package com.ufcg.learningjwt.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ufcg.learningjwt.model.User;
import com.ufcg.learningjwt.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User("maria@gmail.com", "Maria Brown", "123456");
		User u2 = new User("alex@gmail.com", "Alex Green", "123456");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
	}
}