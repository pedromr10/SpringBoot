package com.pedro.jijidoces.dtos.product;

import java.math.BigDecimal;

import com.pedro.jijidoces.enums.ProductStyle;
import com.pedro.jijidoces.enums.ProductType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class ProductResponseDTO {
	private Long id;
	private String flavour;
	private BigDecimal weight;
	private BigDecimal price;
    private ProductType productType;
    private ProductStyle productStyle;
}
