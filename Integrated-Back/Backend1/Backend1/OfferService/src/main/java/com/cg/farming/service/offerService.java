package com.cg.farming.service;


import java.util.List;

import com.cg.Exceptions.OfferNotFoundException;
import com.cg.farming.entity.offer;

public interface offerService {
	
	public offer viewOffer(String offer_Id)throws OfferNotFoundException;
	public List<offer> getOffer(String Person)throws OfferNotFoundException;
	public String deleteOffer(String offer_Id)throws OfferNotFoundException;
	public String addOffer(offer offer);
	public String editOffer(offer offer);
	

}
