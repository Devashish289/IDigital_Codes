package com.cg.farming.contoller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cg.Exceptions.OfferIdAlreadyExistException;
import com.cg.Exceptions.OfferNotFoundException;
import com.cg.util.offerConstants;

@ControllerAdvice

public class FarmingAssistantExceptionAdvice {
	


	
	@ExceptionHandler(value = {OfferNotFoundException.class})
	@ResponseStatus(code= HttpStatus.NOT_FOUND)
	@ResponseBody
	public Map<String,String> handlerException1(Exception ex) {
		
		Map<String,String> map = new HashMap<>();
		map.put("message", offerConstants.OFFER_NOT_FOUND);
		return map;
	}
	@ExceptionHandler(value = {OfferIdAlreadyExistException.class})
	@ResponseStatus(code= HttpStatus.NOT_FOUND)
	@ResponseBody
    public Map<String,String> handlerException2(Exception ex) {
		
		Map<String,String> map = new HashMap<>();
		map.put("message", offerConstants.OFFER_ALREADY_EXIST);
		return map;
}
	

		
	

}