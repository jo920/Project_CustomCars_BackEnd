package com.jh.car.service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationBadRequest {

	// estou implementando ainda
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity Erro400(MethodArgumentNotValidException ex) {
		var erros = ex.getFieldErrors();

		return ResponseEntity.badRequest().body(erros);
	}
	
	
}
