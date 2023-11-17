package com.capgemini.pms.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profile 
{
	@Id
	@Column(name="user_Id")
	String userId;
	@Column(name="user_Name")
	String userName;
	@Column(name = "phone_Number")
	String phoneNumber;
	String address;
	String location;
	String role;
	public Profile() {}
	public Profile(String userId, String userName, String phoneNumber, String address, String location, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.location = location;
		this.role = role;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
