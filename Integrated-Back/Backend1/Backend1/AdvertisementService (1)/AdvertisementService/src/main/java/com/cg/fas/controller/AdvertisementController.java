package com.cg.fas.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fas.dto.AdvertisementDto;
import com.cg.fas.service.AdvertisementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin("*")
@Api("Advertisement Management Service")
public class AdvertisementController {
	@Autowired
	AdvertisementService advertisementService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@PostMapping(value = "/addAdvertisement")
	@ApiOperation(value = "Add new advertisement")
	public ResponseEntity<AdvertisementDto> addAdvertisement(@ApiParam(value="Advertisement in json format") @RequestBody AdvertisementDto advertisement)
	{
		logger.info("Adding new Advertisement to the database");
		AdvertisementDto adDto = advertisementService.addAdvertisement(advertisement);
		return new ResponseEntity<>(adDto,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteAdvertisement/{advertisementId}")
	@ApiOperation(value = "Delete Advertisement")
	public ResponseEntity<String> deleteAdvertisement(@ApiParam(value="Advertisement Id of Ad to be deleted")@PathVariable String advertisementId)
	{
		logger.info("Deleting Advertisement from the database");
		String responseStatement =  advertisementService.deleteAdvertisement(advertisementId);
		return new ResponseEntity<>(responseStatement,HttpStatus.OK);
	}
	
	@GetMapping(value = "/myAds/{userId}")
	@ApiOperation(value = "Display adds posted by me")
	public ResponseEntity<List<AdvertisementDto>> viewMyAdvertisements(@ApiParam(value="UserId of user to display ads")@PathVariable String userId)
	{
		logger.info("Displaying ads");
		List<AdvertisementDto> adsList = advertisementService.viewMyAdvertisements(userId);
		return new ResponseEntity<>(adsList,HttpStatus.OK);
	}
	
	@GetMapping(value = "/ads/{userId}/{role}")
	@ApiOperation(value = "Display Advertisements")
	public ResponseEntity<List<AdvertisementDto>> viewAdvertisements(@ApiParam(value="UserId of user to display ads ")@PathVariable String userId,@ApiParam(value="Role of the User ") @PathVariable String role)
	{
		logger.info("Displaying ads to " + role);
		List<AdvertisementDto> adsList = advertisementService.viewAdvertisements(userId, role);
		return new ResponseEntity<>(adsList,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getId")
	@ApiOperation(value = "Display Advertisement Id")
	public ResponseEntity<String> getLastAdvertisementId()
	{
		logger.info("Displaying last Advertisement Id ");
		String advertisementId = advertisementService.getLastAdvertisementId();
		return new ResponseEntity<>(advertisementId,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAd/{adId}")
	@ApiOperation(value = "Display Advertisement by Id")
	public ResponseEntity<AdvertisementDto> getAdvertisementById(@ApiParam(value="Advertisement Id to display ad ")@PathVariable String adId)
	{
		logger.info("Displaying Advertisement ");
		AdvertisementDto adDto = advertisementService.getAdvertisementById(adId);
		return new ResponseEntity<>(adDto,HttpStatus.OK);
	}
}
