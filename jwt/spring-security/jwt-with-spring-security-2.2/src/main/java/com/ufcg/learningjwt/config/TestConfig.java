package com.ufcg.learningjwt.config;

import com.ufcg.learningjwt.model.Role;
import com.ufcg.learningjwt.model.User;
import com.ufcg.learningjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.ufcg.learningjwt.repository.RoleRepository;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode("123456");

		Role role1 = new Role("ROLE_USER");
		Role role2 = new Role("ROLE_ADMIN");
		
		User u1 = new User("maria@gmail.com", "Maria Brown", encodedPassword, role1);
		User u2 = new User("alex@gmail.com", "Alex Green", encodedPassword, role2);

		roleRepository.saveAll(Arrays.asList(role1, role2));
		userRepository.saveAll(Arrays.asList(u1,u2));
	}
}