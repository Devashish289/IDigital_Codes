package com.cg.farming.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Exceptions.OfferIdAlreadyExistException;
import com.cg.Exceptions.OfferNotFoundException;
import com.cg.farming.entity.offer;
import com.cg.farming.service.offerService;
import com.cg.util.offerConstants;

@CrossOrigin("*")
@RestController
public class offerController {
	
	
	@Autowired
	private offerService ser;
	
    @GetMapping("/getoffers/{person}")
    public List<offer> getOffers(@PathVariable("person")String Person)throws OfferNotFoundException{
    	
    	return ser.getOffer(Person);
    }
	 
    
    @GetMapping("/viewoffer/{offer_Id}")
    public offer viewOffer(@PathVariable("offer_Id") String offerId)throws OfferNotFoundException{
    	
    	offer offer1 = ser.viewOffer(offerId);
    	if(offer1!=null)
    	 return offer1;
    	else
    		throw new OfferNotFoundException();
    }
    
    @PostMapping("/addoffer")
    public String addOffer(@RequestBody offer offer1) throws OfferIdAlreadyExistException{
    	try {
    	ser.addOffer(offer1);
    	return offerConstants.OFFER_ADDED;
    	}catch(DataIntegrityViolationException ex) {
    		throw new OfferIdAlreadyExistException(offerConstants.OFFER_ALREADY_EXIST);
    	}
    }
    
    
    @DeleteMapping("/deleteoffer/{offer_Id}")
    public String deleteOffer(@PathVariable("offer_Id")String offerId)throws OfferNotFoundException{
    	
    	
    	return ser.deleteOffer(offerId);
    	
    }

    
    @PutMapping("/editoffer")
    public String editOffer(@RequestBody offer offer1) {
    	
    	return ser.editOffer(offer1);
    }
}
