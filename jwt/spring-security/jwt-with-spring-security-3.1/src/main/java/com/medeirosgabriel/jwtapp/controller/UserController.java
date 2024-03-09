package com.medeirosgabriel.jwtapp.controller;

import com.medeirosgabriel.jwtapp.dto.UserDTO;
import com.medeirosgabriel.jwtapp.model.User;
import com.medeirosgabriel.jwtapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/v1/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> insertUser(@Valid @RequestBody UserDTO user) {
        Long roleId = 2L;
        this.userService.insertUser(user, 2L);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        ArrayList<User> users = (ArrayList<User>) this.userService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
