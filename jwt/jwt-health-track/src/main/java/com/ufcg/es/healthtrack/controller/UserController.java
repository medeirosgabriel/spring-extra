package com.ufcg.es.healthtrack.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.es.healthtrack.dto.UserDTO;
import com.ufcg.es.healthtrack.service.JWTService;
import com.ufcg.es.healthtrack.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTService jwtService;

    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody UserDTO userDTO) {
        try {
            userService.insertUser(userDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/test")
    public ResponseEntity test(ServletRequest servletRequest) {
        return new ResponseEntity<>(
                "Logged User: "
                + jwtService.getEmailLoggedUser(((HttpServletRequest) servletRequest).getHeader("Authorization"))
                , HttpStatus.OK);
    }
}
