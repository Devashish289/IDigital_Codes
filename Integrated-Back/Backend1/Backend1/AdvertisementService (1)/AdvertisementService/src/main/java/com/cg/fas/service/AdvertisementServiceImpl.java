package com.cg.fas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fas.dao.AdvertisementDao;
import com.cg.fas.dto.AdvertisementDto;
import com.cg.fas.entity.AdvertisementEntity;
import com.cg.fas.exception.AdvertisementNotFoundException;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {
	@Autowired
	AdvertisementDao dao;

	@Override
	public AdvertisementDto addAdvertisement(AdvertisementDto advertisement) {
		AdvertisementEntity adEntity = new AdvertisementEntity(advertisement);
		AdvertisementEntity entity = dao.save(adEntity);
		AdvertisementDto advertisementDto = new AdvertisementDto(entity);
		return advertisementDto;
	}

	@Override
	public String deleteAdvertisement(String advertisementId) {
		AdvertisementEntity adEntity = dao.findById(advertisementId).orElse(null);
		dao.delete(adEntity);
		return "\"Advertisement deleted successfully\"";
	}

	@Override
	public List<AdvertisementDto> viewMyAdvertisements(String userId) {
		List<AdvertisementEntity> adList = dao.findByAdvertisementOwnerId(userId);
		List<AdvertisementDto> myAdsList = new ArrayList<AdvertisementDto>();
		for(AdvertisementEntity ad : adList)
		{
			AdvertisementDto adDto = new AdvertisementDto(ad);
			myAdsList.add(adDto);
		}
		if(myAdsList.size()>0)
		{
			return myAdsList;
		}
		else 
		{
			throw new AdvertisementNotFoundException();
		}
		
	}

	@Override
	public List<AdvertisementDto> viewAdvertisements(String userId, String role) {
		String targetedAudience;
		List<AdvertisementEntity> adList;
		List<AdvertisementDto> adsList = new ArrayList<>();
		if(role.equals("Farmer"))
		{
			targetedAudience = "Farmer";
			adList = dao.findByTargetedAudience(targetedAudience);
			for(AdvertisementEntity ad : adList)
			{
				AdvertisementDto adDto = new AdvertisementDto(ad);
				adsList.add(adDto);
			}
		}
		else if(role.equals("Supplier"))
		{
			targetedAudience = "Supplier";
			adList = dao.findByTargetedAudience(targetedAudience);
			for(AdvertisementEntity ad : adList)
			{
				AdvertisementDto adDto = new AdvertisementDto(ad);
				adsList.add(adDto);
			}
		}
		else if(role.equals("Retailer"))
		{
			targetedAudience = "Retailer";
			adList = dao.findByTargetedAudience(targetedAudience);
			for(AdvertisementEntity ad : adList)
			{
				AdvertisementDto adDto = new AdvertisementDto(ad);
				adsList.add(adDto);
			}
		}
		if(adsList.size()>0)
		{
			return adsList;
		}
		else
		{
			throw new AdvertisementNotFoundException();
		}
		
	}
	@Override
	public String getLastAdvertisementId() {
		List<AdvertisementEntity>adsList = dao.findAll();
		AdvertisementEntity ad = adsList.get(adsList.size()-1);
		return "\""+ad.getAdvertisementId()+"\"";
	}
	@Override
	public AdvertisementDto getAdvertisementById(String advertisementId) {
		AdvertisementEntity ad = dao.findById(advertisementId).orElse(null);
		AdvertisementDto adDto = new AdvertisementDto(ad);
		return adDto;
	}

}
