package br.com.medeirosgabriel.service;

import br.com.medeirosgabriel.entity.Role;
import br.com.medeirosgabriel.dto.UserDTO;
import br.com.medeirosgabriel.entity.User;
import br.com.medeirosgabriel.respository.RoleRepository;
import br.com.medeirosgabriel.respository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User insertUser(UserDTO userDTO) {
        Role role = this.roleRepository.findById(userDTO.getRole()).get();

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(userDTO.getPassword());
        User user = new User(userDTO.getName(), userDTO.getCpf(), userDTO.getEmail(), password, userDTO.getAddress(), role);
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(String userId) {
        return this.userRepository.findById(userId).get();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.userRepository.findByEmail(email).get(0);
    }
}
