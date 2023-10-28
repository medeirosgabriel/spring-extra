package br.com.medeirosgabriel.respository;

import br.com.medeirosgabriel.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> { }
