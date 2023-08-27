package com.ufcg.learningjwt.resource;

import javax.servlet.http.HttpServletResponse;

import com.ufcg.learningjwt.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ufcg.learningjwt.model.User;
import com.ufcg.learningjwt.service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> insertUser(@RequestBody UserDTO user, HttpServletResponse response) {
		User newUser = this.userService.insertUser(user);
		return ResponseEntity.ok(newUser);
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<User> findUserById(@PathVariable("email") String email) {
		User user = this.userService.findUserById(email).get();
		return ResponseEntity.ok(user);
	}
}
