package com.cg.fas.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cg.fas.dto.AdvertisementDto;

@Table(name = "advertisement")
@Entity
public class AdvertisementEntity {

	@Id
	private String advertisementId;
	private double advertisementPricePerQuintal;
	private String advertisementCropId;
	private String quantityInQuintals;
	private String purpose;
	private String targetedAudience;
	public String advertisementOwnerId;
	
	
	public String getAdvertisementId() {
		return advertisementId;
	}
	public void setAdvertisementId(String advertisementId) {
		this.advertisementId = advertisementId;
	}
	public double getAdvertisementPricePerQuintal() {
		return advertisementPricePerQuintal;
	}
	public void setAdvertisementPricePerQuintal(double advertisementPricePerQuintal) {
		this.advertisementPricePerQuintal = advertisementPricePerQuintal;
	}
	public String getAdvertisementCropId() {
		return advertisementCropId;
	}
	public void setAdvertisementCropId(String advertisementCropId) {
		this.advertisementCropId = advertisementCropId;
	}
	public String getQuantityInQuintals() {
		return quantityInQuintals;
	}
	public void setQuantityInQuintals(String quantityInQuintals) {
		this.quantityInQuintals = quantityInQuintals;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getTargetedAudience() {
		return targetedAudience;
	}
	public void setTargetedAudience(String targetedAudience) {
		this.targetedAudience = targetedAudience;
	}
	public String getAdvertisementOwnerId() {
		return advertisementOwnerId;
	}
	public void setAdvertisementOwnerId(String advertisementOwnerId) {
		this.advertisementOwnerId = advertisementOwnerId;
	}
	
	public AdvertisementEntity(String advertisementId, double advertisementPricePerQuintal, String advertisementCropId,
			String quantityInQuintals, String purpose, String targetedAudience, String advertisementOwnerId) {
		super();
		this.advertisementId = advertisementId;
		this.advertisementPricePerQuintal = advertisementPricePerQuintal;
		this.advertisementCropId = advertisementCropId;
		this.quantityInQuintals = quantityInQuintals;
		this.purpose = purpose;
		this.targetedAudience = targetedAudience;
		this.advertisementOwnerId = advertisementOwnerId;
	}
	public AdvertisementEntity(AdvertisementDto adDto) {
		super();
		this.advertisementId = adDto.getAdvertisementId();
		this.advertisementPricePerQuintal = adDto.getAdvertisementPricePerQuintal();
		this.advertisementCropId = adDto.getAdvertisementCropId();
		this.quantityInQuintals = adDto.getQuantityInQuintals();
		this.purpose = adDto.getPurpose();
		this.targetedAudience = adDto.getTargetedAudience();
		this.advertisementOwnerId = adDto.getAdvertisementOwnerId();
	}
	public AdvertisementEntity() {
		super();
	}
	@Override
	public String toString() {
		return "AdvertisementEntity [advertisementId=" + advertisementId + ", advertisementPricePerQuintal="
				+ advertisementPricePerQuintal + ", advertisementCropId=" + advertisementCropId
				+ ", quantityInQuintals=" + quantityInQuintals + ", purpose=" + purpose + ", targetedAudience="
				+ targetedAudience + ", advertisementOwnerId=" + advertisementOwnerId + "]";
	}
	
	
}
