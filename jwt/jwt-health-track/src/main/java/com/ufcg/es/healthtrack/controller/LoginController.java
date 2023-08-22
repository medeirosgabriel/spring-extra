package com.ufcg.es.healthtrack.controller;

import com.ufcg.es.healthtrack.dto.CredentialsDTO;
import com.ufcg.es.healthtrack.dto.LoginResponseDTO;
import com.ufcg.es.healthtrack.service.JWTService;
import com.ufcg.es.healthtrack.exceptions.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/login")
public class LoginController {

    @Autowired
    private JWTService jwtService;

    @PostMapping
    public ResponseEntity<LoginResponseDTO> loginUsuario(@RequestBody CredentialsDTO credentialsDTO) {
      try {
          return new ResponseEntity<LoginResponseDTO>(jwtService.authenticate(credentialsDTO), HttpStatus.OK);
      } catch (InvalidCredentialsException e) {
          return new ResponseEntity<LoginResponseDTO>(new LoginResponseDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
      }
    }
}
