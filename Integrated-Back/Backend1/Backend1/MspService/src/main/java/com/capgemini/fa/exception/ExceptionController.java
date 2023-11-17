package com.capgemini.fa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = {CustomException.class})
	protected ResponseEntity<ErrorInfo> handleCustomException(Exception ex) {
		ErrorInfo error= new ErrorInfo(ex.getMessage());
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
