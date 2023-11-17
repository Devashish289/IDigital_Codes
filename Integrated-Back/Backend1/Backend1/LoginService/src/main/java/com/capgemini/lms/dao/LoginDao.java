package com.capgemini.lms.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.capgemini.lms.dto.Login;

@Repository
public interface LoginDao extends JpaRepository<Login, String>
{
	public List<Login> findByRole(String role);
}
