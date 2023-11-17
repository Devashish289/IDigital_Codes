package com.cg.farming.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.farming.dao.offerDao;
import com.cg.farming.entity.offer;
import com.cg.Exceptions.OfferNotFoundException;
import com.cg.util.offerConstants;

@Service("OrderService")
@Transactional
public class offerServiceImpl implements offerService {
	
	
	@Autowired
	private offerDao dao;
	
	

	@Override
	public offer viewOffer(String offer_Id)throws OfferNotFoundException{
	
		offer offer1 = dao.viewOffer(Integer.parseInt(offer_Id));
		if(offer1!=null)
			return offer1;
		else
			throw new OfferNotFoundException(offerConstants.OFFER_NOT_FOUND);
	}

	@Override
	public List<offer> getOffer(String Person)throws OfferNotFoundException {
		
		List<offer> offer = dao.viewAllOffer(Person);
		if(offer.size()!=0)
			return offer;
		else
			throw new OfferNotFoundException(offerConstants.OFFER_NOT_FOUND);
	}

	@Override
	public String deleteOffer(String offer_Id)throws OfferNotFoundException {
		
		if(dao.deleteOffer(Integer.parseInt(offer_Id))){
				return offerConstants.OFFER_DELETED;}
		else
			throw new OfferNotFoundException(offerConstants.OFFER_NOT_FOUND);
	}

	@Override
	public String addOffer(offer offer) {
		dao.addOffer(offer);
		return offerConstants.OFFER_ADDED;
	}

	@Override
	public String editOffer(offer offer) {
	dao.editOffer(offer);
		return offerConstants.OFFER_EDITED;
	}

}
