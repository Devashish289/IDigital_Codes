package com.cg.fas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.fas.exception.AdvertisementNotFoundException;

@ControllerAdvice
public class AdvertisementControllerAdvice {

	@ExceptionHandler(AdvertisementNotFoundException.class)
	public ResponseEntity<String> advertisementNotFoundException(final AdvertisementNotFoundException e)
	{
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
}
