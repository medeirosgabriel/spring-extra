package br.com.medeirosgabriel.respository;

import br.com.medeirosgabriel.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
