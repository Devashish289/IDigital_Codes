package com.cg.fas.dto;

import com.cg.fas.entity.AdvertisementEntity;

public class AdvertisementDto {

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
	
	public AdvertisementDto(String advertisementId, double advertisementPricePerQuintal, String advertisementCropId,
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
	public AdvertisementDto(AdvertisementEntity adEntity) {
		super();
		this.advertisementId = adEntity.getAdvertisementId();
		this.advertisementPricePerQuintal = adEntity.getAdvertisementPricePerQuintal();
		this.advertisementCropId = adEntity.getAdvertisementCropId();
		this.quantityInQuintals = adEntity.getQuantityInQuintals();
		this.purpose = adEntity.getPurpose();
		this.targetedAudience = adEntity.getTargetedAudience();
		this.advertisementOwnerId = adEntity.getAdvertisementOwnerId();
	}
	public AdvertisementDto() {
		super();
	}
	@Override
	public String toString() {
		return "AdvertisementDto [advertisementId=" + advertisementId + ", advertisementPricePerQuintal="
				+ advertisementPricePerQuintal + ", advertisementCropId=" + advertisementCropId
				+ ", quantityInQuintals=" + quantityInQuintals + ", purpose=" + purpose + ", targetedAudience="
				+ targetedAudience + ", advertisementOwnerId=" + advertisementOwnerId + "]";
	}
	
	
	
}
