package com.pedro.jijidoces.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class ErrorResponseDTO {
	@Schema(description = "Error timestamp", example = "2026-05-25T12:00:00")
	private LocalDateTime timestamp;
	@Schema(description = "HTTP status code", example = "404")
	private Integer status;
	@Schema(description = "Error messages", example = "[\"Product not found\"]")
	private List<String> messages;
	@Schema(description = "Request path", example = "/api/v1/products/99")
	private String path;
}
