package com.pedro.financeapi.exception;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter

public class ErrorResponse {
	private LocalDateTime timeStamp;
	private int status;
	private String error;
	private String message;
	private String path;
}
