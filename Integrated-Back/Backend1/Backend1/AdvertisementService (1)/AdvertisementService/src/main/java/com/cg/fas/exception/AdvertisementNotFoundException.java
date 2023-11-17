package com.cg.fas.exception;

public class AdvertisementNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdvertisementNotFoundException() {
		super("There exist no Advertisement to display");
		
	}

}
