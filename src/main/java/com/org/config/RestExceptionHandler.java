package com.org.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleRuntimeException(RuntimeException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleRuntimeException(Exception exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
	
}
