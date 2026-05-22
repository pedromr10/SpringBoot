package com.pedro.jijidoces.dtos.product;

import java.math.BigDecimal;

import com.pedro.jijidoces.enums.ProductStyle;
import com.pedro.jijidoces.enums.ProductType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
	@NotBlank
	private String flavour;
	@NotNull
	private BigDecimal weight;
	@NotNull
	private BigDecimal price;
	@NotNull
	private ProductType productType;
	@NotNull
	private ProductStyle productStyle;
}
