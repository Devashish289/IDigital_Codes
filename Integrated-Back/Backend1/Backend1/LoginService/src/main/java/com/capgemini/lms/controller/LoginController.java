package com.capgemini.lms.controller;
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
import com.capgemini.lms.dto.Login;
import com.capgemini.lms.service.LoginService;


@RestController
@CrossOrigin("*")
public class LoginController 
{
	@Autowired
	LoginService loginService;
	public void setLoginService(LoginService loginService)
	{
		this.loginService = loginService;
	}
	
	@GetMapping(value="/login/{userId}/{password}/{role}",produces="application/json")   
	public ResponseEntity<Optional<Login>> login(@PathVariable String userId,@PathVariable String password,@PathVariable String role)
	{    
		Optional<Login> login = loginService.checkLoginDetails(userId);
		if(login.isPresent() && login.get().getPassword().equals(password) && login.get().getRole().equals(role)) 
			return new ResponseEntity<Optional<Login>>(login,HttpStatus.OK);
		return new ResponseEntity<Optional<Login>>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(value="/updateLoginDetails",consumes="application/json")
	public ResponseEntity<String> updateLoginDetails(@RequestBody() Login login)
	{
		if(loginService.updateLoginDetails(login)==null) {
			return new ResponseEntity<String>("{}",HttpStatus.BAD_REQUEST);		 
		}
		return new ResponseEntity<String>("{}",HttpStatus.OK);
	} 
	
	@PostMapping(value = "/addLoginDetails")
	public ResponseEntity<String> addLoginDetails(@RequestBody Login login)
	{
		if(loginService.addLoginDetails(login.getUserId(),login.getPassword(),login.getRole())==null) {
			return new ResponseEntity<String>("{}",HttpStatus.BAD_REQUEST);		 
		}
		return new ResponseEntity<String>("\"Success\"",HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteLoginDetails/{userId}")
	public ResponseEntity<String> deleteLoginDetails(@PathVariable String userId)
	{
		try
		{
			loginService.deleteLoginDetails(userId);
			return new ResponseEntity<String>("{}",HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>("{}",HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/getUserIdbyRole/{role}")
	public ResponseEntity<String> getUserIdbyRole(@PathVariable String role)
	{
		String userId = loginService.getUserIdbyRole(role);
		if(userId!=null)
			return new ResponseEntity<String>(userId,HttpStatus.OK);
		return new ResponseEntity<String>(userId,HttpStatus.NOT_FOUND);
	}
	@GetMapping("/getLoginDetails/{userId}")
	public ResponseEntity<Optional<Login>> getLoginDetails(@PathVariable String userId)
	{
		Optional<Login> login = loginService.getLoginDetails(userId);
		if(login.isPresent())
			return new ResponseEntity<Optional<Login>>(login,HttpStatus.OK);
		return new ResponseEntity<Optional<Login>>(login,HttpStatus.NOT_FOUND);
	}

}
