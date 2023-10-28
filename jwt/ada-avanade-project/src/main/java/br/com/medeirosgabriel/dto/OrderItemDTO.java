package br.com.medeirosgabriel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItemDTO {
    private Long orderId;
    private String productId;
    private Integer quantity;
}
