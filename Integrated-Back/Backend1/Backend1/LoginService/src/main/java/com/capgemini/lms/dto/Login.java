package com.capgemini.lms.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login 
{
	@Id
	@Column(name="user_Id")
	String userId;
	String password;
	String role;
	public Login() {}
	public Login(String userId, String password, String role) {
		this.userId = userId;
		this.password = password;
		this.role = role;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
