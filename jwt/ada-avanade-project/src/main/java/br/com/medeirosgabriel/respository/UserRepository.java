package br.com.medeirosgabriel.respository;

import br.com.medeirosgabriel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByEmail(String email);

}
