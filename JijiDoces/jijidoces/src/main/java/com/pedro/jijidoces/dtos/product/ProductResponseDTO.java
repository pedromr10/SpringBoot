package com.pedro.jijidoces.dtos.product;

import java.math.BigDecimal;

import com.pedro.jijidoces.enums.ProductStyle;
import com.pedro.jijidoces.enums.ProductType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class ProductResponseDTO {
	@Schema(description = "Product id", example = "1")
	private Long id;
	@Schema(description = "Product flavour", example = "Nutella")
	private String flavour;
	@Schema(description = "Product weight", example = "100")
	private BigDecimal weight;
	@Schema(description = "Product price", example = "15.00")
	private BigDecimal price;
	@Schema(description = "Product type", example = "COOKIE")
    private ProductType productType;
	@Schema(description = "Product style", example = "RECHEADO")
    private ProductStyle productStyle;
}
