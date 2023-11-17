package com.cog.complaintapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cog.complaintapi.dto.Complaint;
import com.cog.complaintapi.service.ComplaintService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ComplaintController {

	
@Autowired
public ComplaintService complaintService;
@GetMapping("/complaints")
public List<Complaint> getComplaints()
{
	return complaintService.getComplaints();
}
@GetMapping("/complaints/{status}")
public List<Complaint> getComplaintsByStatus(@PathVariable("status") String status)
{
	return complaintService.getComplaintsByStatus(status);
}
@GetMapping("/complaints/complain/{id}")
public Complaint getComplaintsByComplaintId(@PathVariable("id") String id)
{
	return complaintService.getComplaintsByComplaintId(id);
}
@PutMapping("/complaints")
public Complaint updateComplaintsStatus(@RequestBody Complaint com)
{
	 return complaintService.updateComplaintsStatus(com);
}
@PostMapping("/complaints")
public Complaint addComplaint(@RequestBody Complaint com)
{
	return complaintService.addComplaint(com);
}
}
