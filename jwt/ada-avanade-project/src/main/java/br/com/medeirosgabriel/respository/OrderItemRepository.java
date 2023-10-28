package br.com.medeirosgabriel.respository;

import br.com.medeirosgabriel.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}
