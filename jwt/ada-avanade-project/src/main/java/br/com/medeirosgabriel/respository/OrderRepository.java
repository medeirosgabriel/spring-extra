package br.com.medeirosgabriel.respository;

import br.com.medeirosgabriel.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> { }
