package com.pedro.jijidoces.dtos.orderItem;

import jakarta.validation.constraints.NotNull;

public class OrderItemRequestDTO {
    @NotNull
    private Long orderId;
    @NotNull
    private Long productId;
    @NotNull
    private Integer quantity;
}
