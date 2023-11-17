package com.capgemini.lms.service;
import java.util.Optional;
import com.capgemini.lms.dto.Login;

public interface LoginService 
{
	public Optional<Login> checkLoginDetails(String userId);
	public Login addLoginDetails(String userId, String password, String role);
	public Login updateLoginDetails(Login login);
	public void deleteLoginDetails(String userId);
	public String getUserIdbyRole(String role);
	public Optional<Login> getLoginDetails(String userId);
}
