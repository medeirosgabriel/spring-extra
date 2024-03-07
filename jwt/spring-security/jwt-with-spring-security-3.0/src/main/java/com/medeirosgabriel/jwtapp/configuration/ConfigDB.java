package com.medeirosgabriel.jwtapp.configuration;

import com.medeirosgabriel.jwtapp.dto.UserDTO;
import com.medeirosgabriel.jwtapp.model.Role;
import com.medeirosgabriel.jwtapp.repository.RoleRepository;
import com.medeirosgabriel.jwtapp.repository.UserRepository;
import com.medeirosgabriel.jwtapp.service.RoleService;
import com.medeirosgabriel.jwtapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigDB implements CommandLineRunner {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        this.roleService.insertRole("ROLE_ADMIN");
        this.roleService.insertRole("ROLE_USER");
        this.userService.insertUser(new UserDTO("gabrielpm814@gmail.com", "1234", "Gabriel", 25), 1L);
    }
}
