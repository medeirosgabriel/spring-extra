package com.ufcg.es.healthtrack.service;

import com.ufcg.es.healthtrack.model.User;
import com.ufcg.es.healthtrack.dto.UserDTO;
import com.ufcg.es.healthtrack.repository.UserRepository;
import com.ufcg.es.healthtrack.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void insertUser(UserDTO userDTO) {
        verifyUserData(userDTO);
        verifyEmailAlreadyRegistered(userDTO.getEmail());
        this.repository.save(createUser(userDTO));
    }

    public List<User> list() {
        return repository.findAll();
    }

    private void verifyUserData(UserDTO userDTO) {
        Util.verifyNull(userDTO.getName(), "Name");
        Util.verifyEmptyString(userDTO.getName(), "Name");

        Util.verifyNull(userDTO.getEmail(), "E-mail");
        Util.verifyEmptyString(userDTO.getEmail(), "E-mail");
        Util.verifyEmailFormat(userDTO.getEmail());

        Util.verifyNull(userDTO.getPassword(), "Password");
        Util.verifyEmptyString(userDTO.getPassword(), "Password");
        Util.verifyPasswordFormat(userDTO.getPassword());
    }

    private void verifyEmailAlreadyRegistered(String email) {
        Optional<User> optionalUser = this.repository.findById(email);

        if(optionalUser.isPresent()) {
            throw new IllegalArgumentException("E-mail already registered.");
        }
    }

    private User createUser(UserDTO userDTO) {
        return new User(userDTO.getEmail(), userDTO.getName(), userDTO.getPassword());
    }

    public boolean validateUser(String email, String password) {
        Optional<User> optionalUser = this.repository.findById(email);
        return (optionalUser.isPresent() && optionalUser.get().verifyPassword(password));

    }
}
