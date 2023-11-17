package com.capgemini.pms.controller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.pms.dto.Profile;
import com.capgemini.pms.service.ProfileService;


@RestController
@CrossOrigin("*")
public class ProfileController 
{
	@Autowired
	ProfileService profileService;

	public void setProfileService(ProfileService profileService)
	{
		this.profileService = profileService;
	}

	@PostMapping(value = "/register")
	public ResponseEntity<String> registerUser(@RequestBody Profile profile)
	{
		System.out.println("Startted Function");
		if(profileService.addProfile(profile)==null) {
			return new ResponseEntity<String>("{}",HttpStatus.BAD_REQUEST);		 
		}
		return new ResponseEntity<String>("\"Success\"",HttpStatus.OK);
	}

	@PutMapping(value="/updateProfile",consumes="application/json")
	public ResponseEntity<String> updateProfile(@RequestBody Profile profile)
	{
		if(profileService.updateProfile(profile)==null) {
			return new ResponseEntity<String>("{}",HttpStatus.BAD_REQUEST);		 
		}
		return new ResponseEntity<String>("{}",HttpStatus.OK);
	} 
	@GetMapping(value="/viewProfile/{userId}",produces="application/json")
	public ResponseEntity<Optional<Profile>> viewProfile(@PathVariable String userId)
	{
		Optional<Profile> profile = profileService.viewProfile(userId);
		if(profile.isPresent())
			return new ResponseEntity<Optional<Profile>>(profile,HttpStatus.OK);
		return new ResponseEntity<Optional<Profile>>(profile,HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/deleteProfile/{userId}")
	public ResponseEntity<String> deleteProfile(@PathVariable String userId)
	{
		try
		{
			profileService.deleteProfile(userId);
			return new ResponseEntity<String>("{}",HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>("{}",HttpStatus.BAD_REQUEST);
		}
	}
	/*@GetMapping("/getUserIdbyRole/{role}")
	public ResponseEntity<String> getUserIdbyRole(@PathVariable String role)
	{
		String userId = profileService.getUserIdbyRole(role);
		if(userId!=null)
			return new ResponseEntity<String>(userId,HttpStatus.OK);
		return new ResponseEntity<String>(userId,HttpStatus.NOT_FOUND);
	} */

}
