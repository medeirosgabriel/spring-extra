package com.ufcg.learningjwt.resource;


import com.ufcg.learningjwt.model.Credentials;
import com.ufcg.learningjwt.service.TokenAuthenticationService;
import com.ufcg.learningjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/login")
public class LoginResource {

    @Autowired
    private UserService userService;
    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody Credentials credentials, HttpServletResponse response){
        String token = tokenAuthenticationService.getToken(credentials.getEmail());
        return ResponseEntity.ok(token);
    }
}
