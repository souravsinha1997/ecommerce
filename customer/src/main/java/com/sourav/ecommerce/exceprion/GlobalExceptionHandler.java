package com.sourav.ecommerce.exceprion;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerNotFoundExceptoion.class)
	public ResponseEntity<String> handle(CustomerNotFoundExceptoion exp){
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				             .body(exp.getMsg());
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException exp){
		ErrorResponse response = new ErrorResponse();
		response.setErrorCode(HttpStatus.BAD_REQUEST);
		response.setErrorDesc(exp.getMessage());
		response.setTimeStamp(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				             .body(response);
	}
}
