package br.com.medeirosgabriel.service;

import br.com.medeirosgabriel.dto.OrderDTO;
import br.com.medeirosgabriel.entity.Order;

import java.util.List;

public interface OrderService {

    Order insertOrder(OrderDTO orderDTO);
    List<Order> getAllOrders();

    Order getOrderById(Long orderId);

    Order updateOrder(Order order);
}
