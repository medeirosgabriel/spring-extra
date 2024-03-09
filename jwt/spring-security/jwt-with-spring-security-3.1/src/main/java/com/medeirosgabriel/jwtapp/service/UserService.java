package com.medeirosgabriel.jwtapp.service;

import com.medeirosgabriel.jwtapp.dto.UserDTO;
import com.medeirosgabriel.jwtapp.model.Role;
import com.medeirosgabriel.jwtapp.model.User;
import com.medeirosgabriel.jwtapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder encoder;

    public void insertUser(UserDTO user, Long roleId) {
        Role role = this.roleService.getRoleById(roleId);
        User newUser = new User(user.getEmail(), encoder.encode(user.getPassword()), user.getName(), user.getAge(), role);
        this.userRepository.save(newUser);
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    private User getUserById(String email) {return this.userRepository.findById(email).get();}

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            return this.getUserById(email);
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException("Email not Found");
        } catch (IllegalArgumentException e) {
            throw new UsernameNotFoundException("Email not Found");
        }
    }
}
