package com.pedro.jijidoces.dtos.orderItem;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OrderItemResponseDTO {
    private Long id;
    private Long orderId;
    private Long productId;
    private String productFlavour;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal subtotal;
}
