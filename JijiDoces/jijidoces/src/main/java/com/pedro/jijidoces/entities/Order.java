package com.pedro.jijidoces.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.pedro.jijidoces.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tb_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String clientName;
	private LocalDateTime deliveryDate;
	private LocalDateTime createdAt;
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	private BigDecimal totalPrice;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> items;
}
