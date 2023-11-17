package com.cog.complaintapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.cog.complaintapi.dto.Complaint;
@Component
public interface ComplaintRepository extends CrudRepository<Complaint, String>{
public List<Complaint> findByComplainStatus(String status);
}
