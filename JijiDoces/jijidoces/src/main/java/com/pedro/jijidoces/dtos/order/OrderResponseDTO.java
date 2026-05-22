package com.pedro.jijidoces.dtos.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.pedro.jijidoces.enums.OrderStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class OrderResponseDTO {
    private Long id;
    private String clientName;
    private LocalDateTime deliveryDate;
    private LocalDateTime createdAt;
    private OrderStatus status;
    private BigDecimal totalPrice;	
}
