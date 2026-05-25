package com.pedro.jijidoces.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class ErrorResponseDTO {
	private LocalDateTime timestamp;
	private Integer status;
	private List<String> messages;
	private String path;
}
