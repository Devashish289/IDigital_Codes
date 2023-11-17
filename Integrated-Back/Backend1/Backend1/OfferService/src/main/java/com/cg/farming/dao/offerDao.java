package com.cg.farming.dao;

import java.util.List;

import com.cg.farming.entity.offer;

public interface offerDao {
	
	public offer viewOffer(int offer_Id);
	public List<offer> viewAllOffer(String Person);
	public boolean deleteOffer(int offer_Id);
	public boolean editOffer(offer offer);
	public boolean addOffer(offer offer);

}
