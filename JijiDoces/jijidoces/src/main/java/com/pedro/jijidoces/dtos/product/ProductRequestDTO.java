package com.pedro.jijidoces.dtos.product;

import java.math.BigDecimal;

import com.pedro.jijidoces.enums.ProductStyle;
import com.pedro.jijidoces.enums.ProductType;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
	@Schema(description = "Product flavour", example = "Nutella")
	@NotBlank
	private String flavour;
	@Schema(description = "Product weight in grams or kilograms", example = "100")
	@NotNull
	private BigDecimal weight;
	@Schema(description = "Product price", example = "15.00")
	@NotNull
	private BigDecimal price;
	@Schema(description = "Product type", example = "COOKIE")
	@NotNull
	private ProductType productType;
	@Schema(description = "Product style", example = "RECHEADO")
	@NotNull
	private ProductStyle productStyle;
}
