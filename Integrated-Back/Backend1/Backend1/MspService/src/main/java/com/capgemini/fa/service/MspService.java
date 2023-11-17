package com.capgemini.fa.service;

import java.util.List;

import com.capgemini.fa.dto.MspDTO;

public interface MspService {
	List<MspDTO> viewAllCrops();
	MspDTO viewCropById(String cropId);
	MspDTO viewCropByName(String cropName);
	MspDTO addCrop(MspDTO crop);
	boolean deleteCropById(String cropId);
	MspDTO update(MspDTO msp);
	
}
