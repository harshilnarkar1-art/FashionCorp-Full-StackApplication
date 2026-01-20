package com.looks.FashionCorp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
	}
	
	@ExceptionHandler(PasswordMismatchException.class)
	public ResponseEntity<String> handlerPasswordMismatch(PasswordMismatchException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password Not Matched");
	}

}
