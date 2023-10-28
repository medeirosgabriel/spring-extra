package br.com.medeirosgabriel.service;

import br.com.medeirosgabriel.entity.Product;
import br.com.medeirosgabriel.dto.ProductDTO;

public interface ProductService {

    Product insertProduct(ProductDTO productDTO);

    Product getProductById(String productId);
}
