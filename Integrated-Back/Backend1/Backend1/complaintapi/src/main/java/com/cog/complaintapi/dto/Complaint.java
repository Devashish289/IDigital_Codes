package com.cog.complaintapi.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="complain")
public class Complaint {
	@Id
	private String complainId;
	private String userId;
	private String allegedPersonId;
	private String complainStatement;
	private String resolutionStatement;
	private String complainStatus;
	public Complaint() {
		// TODO Auto-generated constructor stub
	}
	public String getComplainId() {
		return complainId;
	}
	public void setComplainId(String complainId) {
		this.complainId = complainId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAllegedPersonId() {
		return allegedPersonId;
	}
	public void setAllegedPersonId(String allegedPersonId) {
		this.allegedPersonId = allegedPersonId;
	}
	public String getComplainStatement() {
		return complainStatement;
	}
	public void setComplainStatement(String complainStatement) {
		this.complainStatement = complainStatement;
	}
	public String getResolutionStatement() {
		return resolutionStatement;
	}
	public void setResolutionStatement(String resolutionStatement) {
		this.resolutionStatement = resolutionStatement;
	}
	public String getComplainStatus() {
		return complainStatus;
	}
	public void setComplainStatus(String complainStatus) {
		this.complainStatus = complainStatus;
	}
	public Complaint(String complainId, String userId, String allegedPersonId, String complainStatement,
			String resolutionStatement, String complainStatus) {
		super();
		this.complainId = complainId;
		this.userId = userId;
		this.allegedPersonId = allegedPersonId;
		this.complainStatement = complainStatement;
		this.resolutionStatement = resolutionStatement;
		this.complainStatus = complainStatus;
	}
	@Override
	public String toString() {
		return "Complaint [complainId=" + complainId + ", userId=" + userId + ", allegedPersonId=" + allegedPersonId
				+ ", complainStatement=" + complainStatement + ", resolutionStatement=" + resolutionStatement
				+ ", complainStatus=" + complainStatus + "]";
	}
	

}
