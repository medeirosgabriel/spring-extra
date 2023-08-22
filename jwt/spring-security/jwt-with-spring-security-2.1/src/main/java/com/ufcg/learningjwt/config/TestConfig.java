package com.ufcg.learningjwt.config;

import com.ufcg.learningjwt.model.Role;
import com.ufcg.learningjwt.model.User;
import com.ufcg.learningjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode("123456");

		Set<Role> roles1 = new HashSet<>();
		roles1.add(new Role("ROLE_USER"));

		Set<Role> roles2 = new HashSet<>();
		roles2.add(new Role("ROLE_ADMIN"));
		
		User u1 = new User("maria@gmail.com", "Maria Brown", encodedPassword, roles1);
		User u2 = new User("alex@gmail.com", "Alex Green", encodedPassword, roles2);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
	}
}