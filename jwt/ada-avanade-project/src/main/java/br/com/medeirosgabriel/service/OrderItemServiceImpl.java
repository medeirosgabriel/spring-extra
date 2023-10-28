package br.com.medeirosgabriel.service;

import br.com.medeirosgabriel.entity.Product;
import br.com.medeirosgabriel.dto.OrderItemDTO;
import br.com.medeirosgabriel.entity.Order;
import br.com.medeirosgabriel.entity.OrderItem;
import br.com.medeirosgabriel.respository.OrderItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderServiceImpl orderService;
    private final ProductServiceImpl productService;
    private final OrderItemRepository orderItemRepository;

    @Override
    public OrderItem insertOrderItem(OrderItemDTO orderItemDTO) {
        Order order = this.orderService.getOrderById(orderItemDTO.getOrderId());
        Product product = this.productService.getProductById(orderItemDTO.getProductId());
        OrderItem orderItem = new OrderItem(order, product, orderItemDTO.getQuantity());
        order.addOrderItem(orderItem);
        this.orderService.updateOrder(order);
        return this.orderItemRepository.save(orderItem);
    }
}
