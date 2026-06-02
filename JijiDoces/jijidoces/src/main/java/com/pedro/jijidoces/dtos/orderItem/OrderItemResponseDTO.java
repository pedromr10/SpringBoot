package com.pedro.jijidoces.dtos.orderItem;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class OrderItemResponseDTO {
	@Schema(description = "Order item id", example = "1")
    private Long id;
	@Schema(description = "Order id", example = "1")
    private Long orderId;
	@Schema(description = "Product id", example = "1")
    private Long productId;
	@Schema(description = "Product flavour", example = "Nutella")
    private String productFlavour;
	@Schema(description = "Product quantity", example = "3")
    private Integer quantity;
	@Schema(description = "Product unit price", example = "15.00")
    private BigDecimal unitPrice;
	@Schema(description = "Item subtotal", example = "45.00")
    private BigDecimal subtotal;
}
