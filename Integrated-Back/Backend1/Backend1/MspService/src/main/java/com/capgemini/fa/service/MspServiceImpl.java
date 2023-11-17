package com.capgemini.fa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.fa.dao.MspDao;
import com.capgemini.fa.dto.MspDTO;
import com.capgemini.fa.exception.CustomException;
@Service
public class MspServiceImpl implements MspService {
	@Autowired
	MspDao mspdao;
	@Override
	public List<MspDTO> viewAllCrops() {
		if(mspdao.findAll()!=null)
			return (List<MspDTO>) mspdao.findAll();
		else
			throw new CustomException("No Crop Found");
	}

	@Override
	public MspDTO viewCropById(String cropId) {
		if(mspdao.findById(cropId).isPresent())
			return mspdao.findById(cropId).get();
		else throw new CustomException("No crop found of Id: "+cropId);
	}

	@Override
	public MspDTO viewCropByName(String cropName) {
		if(mspdao.findCropByCropName(cropName)!=null)
			return mspdao.findCropByCropName(cropName);
		else
			throw new CustomException("No crop found with name: "+cropName);
	}

	@Override
	public MspDTO addCrop(MspDTO crop) {
		if(mspdao.findCropByCropName(crop.getCropName())==null)
			return mspdao.save(crop);
		else
			throw new CustomException("Crop already exist with name: "+crop.getCropName());

	}

	@Override
	public boolean deleteCropById(String cropId) {
		if(mspdao.existsById(cropId)) {
			mspdao.deleteById(cropId);
			return true;}
		else
			throw new CustomException("No crop found of Id: "+cropId);



	}

	@Override
	public MspDTO update(MspDTO msp) {
		if(mspdao.existsById(msp.getCropId())){
			return mspdao.save(msp);
		}
		else
			throw new CustomException("No crop found of Id: "+msp.getCropId());
	}

}
