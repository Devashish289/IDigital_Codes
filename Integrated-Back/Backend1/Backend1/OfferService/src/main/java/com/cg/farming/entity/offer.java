package com.cg.farming.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="offer")
@DynamicInsert
@DynamicUpdate
public class offer {
	
	@Id
	@Column(name="offer_Id")
	private int offer_Id;
	
	@Column(name="offerProduct")
	private String offerProduct;
	
	@Column(name="offered_Price_Per_Quintal")
	private int offered_Price_Per_Quintal;
	
	
	private String status;
	private String person;
	
	public int getOffer_Id() {
		return offer_Id;
	}
	public void setOffer_Id(int offer_Id) {
		this.offer_Id = offer_Id;
	}
	public String getOfferProduct() {
		return offerProduct;
	}
	public void setOfferProduct(String offerProduct) {
		this.offerProduct = offerProduct;
	}
	public int getOffered_Price_Per_Quintal() {
		return offered_Price_Per_Quintal;
	}
	public void setOffered_Price_Per_Quintal(int offered_Price_Per_Quintal) {
		this.offered_Price_Per_Quintal = offered_Price_Per_Quintal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}


	
	
	
	
	

}
