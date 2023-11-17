package com.capgemini.fa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.fa.dto.MspDTO;
import com.capgemini.fa.service.MspService;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/msp")
public class MspController {
	@Autowired
	MspService mspService;
	
	@GetMapping("/viewByCropName/{cropName}")
	MspDTO viewCropByCropName(@PathVariable("cropName")String cropName) {
		return mspService.viewCropByName(cropName);
	}
	
	@PostMapping("/addCrop")
	MspDTO addCrop(@RequestBody MspDTO mspDto) {
		return mspService.addCrop(mspDto);
	}
	
	@GetMapping("/viewByCropId/{cropId}")
	MspDTO viewCropByCropId(@PathVariable("cropId")String cropId) {
		return mspService.viewCropById(cropId);
	}
	
	@GetMapping("/viewAll")
	List<MspDTO> viewAllCrops() {
		return mspService.viewAllCrops();
	}
	
	@DeleteMapping("/deleteCropById/{cropId}")
	boolean deleteCropById(@PathVariable("cropId")String cropId) {
		return mspService.deleteCropById(cropId);
	}
	
	@PutMapping("/update")
	MspDTO update(@RequestBody MspDTO msp) {
		return mspService.update(msp);
	}

}
