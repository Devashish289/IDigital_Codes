package com.cg.fas.service;

import java.util.List;

import com.cg.fas.dto.AdvertisementDto;

public interface AdvertisementService {
	public AdvertisementDto addAdvertisement(AdvertisementDto advertisement);
	public String deleteAdvertisement(String advertisementId);
	public List<AdvertisementDto> viewMyAdvertisements(String userId);
	public List<AdvertisementDto> viewAdvertisements(String userId,String role);
	public String getLastAdvertisementId();
	public AdvertisementDto getAdvertisementById(String advertisementId);
	

}
