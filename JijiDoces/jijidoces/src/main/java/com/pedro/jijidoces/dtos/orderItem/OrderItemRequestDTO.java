package com.pedro.jijidoces.dtos.orderItem;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter

public class OrderItemRequestDTO {
	@Schema(description = "Product id", example = "1")
    @NotNull
    private Long productId;
	@Schema(description = "Product quantity", example = "3")
    @NotNull
    private Integer quantity;
}
