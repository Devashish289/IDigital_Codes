package com.capgemini.pms.service;
import java.util.Optional;
import com.capgemini.pms.dto.Profile;

public interface ProfileService 
{
	public Profile addProfile(Profile profile);
	public Profile updateProfile(Profile profile);
	public void deleteProfile(String userId);
	public Optional<Profile> viewProfile(String userId);
	//public String getUserIdbyRole(String role);
}
