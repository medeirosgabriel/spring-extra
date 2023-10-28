package br.com.medeirosgabriel.service;

import br.com.medeirosgabriel.dto.UserDTO;
import br.com.medeirosgabriel.entity.User;

import java.util.List;

public interface UserService {
    User insertUser(UserDTO userDTO);
    List<User> getAllUsers();
    User findById(String userId);
}
