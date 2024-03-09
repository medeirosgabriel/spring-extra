package com.medeirosgabriel.jwtapp.controller;

import com.medeirosgabriel.jwtapp.model.Role;
import com.medeirosgabriel.jwtapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/v1/role/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<?> getRoles() {
        ArrayList<Role> roles = (ArrayList<Role>) this.roleService.getRoles();
        return ResponseEntity.status(HttpStatus.OK).body(roles);
    }
}
