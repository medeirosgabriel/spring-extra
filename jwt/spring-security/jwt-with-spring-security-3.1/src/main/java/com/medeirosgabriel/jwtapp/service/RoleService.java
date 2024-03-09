package com.medeirosgabriel.jwtapp.service;

import com.medeirosgabriel.jwtapp.model.Role;
import com.medeirosgabriel.jwtapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public void insertRole(String name) {
        Role newRole = new Role(name);
        this.roleRepository.save(newRole);
    }

    public Role getRoleById(Long id) {
        return this.roleRepository.findById(id).get();
    }

    public List<Role> getRoles() {
        return this.roleRepository.findAll();
    }
}
