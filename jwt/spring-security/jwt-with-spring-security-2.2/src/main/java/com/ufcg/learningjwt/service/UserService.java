package com.ufcg.learningjwt.service;

import java.util.List;
import java.util.Optional;

import com.ufcg.learningjwt.dto.UserDTO;
import com.ufcg.learningjwt.model.Role;
import com.ufcg.learningjwt.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ufcg.learningjwt.model.User;
import com.ufcg.learningjwt.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	public User insertUser(UserDTO userDTO) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
		List<Role> roles = this.roleRepository.findByName(userDTO.getRoleName());
		User user = new User(userDTO.getEmail(), userDTO.getName(), encodedPassword, roles.get(0));
		return userRepository.save(user);
	}
	
	public Optional<User> findUserById(String email) {
		return userRepository.findById(email);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return this.userRepository.getById(email);
	}
}
