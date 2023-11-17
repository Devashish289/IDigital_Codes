package com.capgemini.fa.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="msp")
public class MspDTO {
	@Id
	String cropId;
	String cropName;
	int mspPrice;
	public String getCropId() {
		return cropId;
	}
	public void setCropId(String cropId) {
		this.cropId = cropId;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public int getMspPrice() {
		return mspPrice;
	}
	public void setMspPrice(int mspPrice) {
		this.mspPrice = mspPrice;
	}
	public MspDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MspDTO(String cropId, String cropName, int mspPrice) {
		super();
		this.cropId = cropId;
		this.cropName = cropName;
		this.mspPrice = mspPrice;
	}
	public MspDTO(String cropName, int mspPrice) {
		super();
		this.cropName = cropName;
		this.mspPrice = mspPrice;
	}
	

}
