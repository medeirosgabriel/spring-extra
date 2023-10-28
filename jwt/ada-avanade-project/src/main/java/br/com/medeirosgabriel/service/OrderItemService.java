package br.com.medeirosgabriel.service;

import br.com.medeirosgabriel.dto.OrderItemDTO;
import br.com.medeirosgabriel.entity.OrderItem;

public interface OrderItemService {

    OrderItem insertOrderItem(OrderItemDTO orderItemDTO);

}
