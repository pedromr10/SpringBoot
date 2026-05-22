package com.pedro.jijidoces.entities;

import java.math.BigDecimal;

import com.pedro.jijidoces.enums.ProductStyle;
import com.pedro.jijidoces.enums.ProductType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "tb_produto")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String flavour;
	private BigDecimal weight;
	private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    @Enumerated(EnumType.STRING)
    private ProductStyle productStyle;
}
