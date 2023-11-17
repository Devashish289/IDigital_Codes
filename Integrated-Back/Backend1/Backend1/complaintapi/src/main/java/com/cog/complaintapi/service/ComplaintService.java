package com.cog.complaintapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cog.complaintapi.dto.Complaint;
import com.cog.complaintapi.repository.ComplaintRepository;
@Component
public class ComplaintService {
	@Autowired
ComplaintRepository complaintRepo;

	public List<Complaint> getComplaints() {
		return (List<Complaint>) complaintRepo.findAll();
	}

	public Complaint updateComplaintsStatus(Complaint complaint) {
		Complaint com=complaintRepo.findById(complaint.getComplainId()).get();
		if(com!=null)
		{
			com.setComplainStatus(complaint.getComplainStatus());
			com.setResolutionStatement(complaint.getResolutionStatement());
		return complaintRepo.save(com);
		}
		return com;
	}

	public Complaint getComplaintsByComplaintId(String id) {
		// TODO Auto-generated method stub
		return complaintRepo.findById(id).get();
	}

	public List<Complaint> getComplaintsByStatus(String status) {
		
		return complaintRepo.findByComplainStatus(status);
	}

	public  Complaint addComplaint(Complaint com) {
		return complaintRepo.save(com);
		
	}
	

}
