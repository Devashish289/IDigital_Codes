package com.cg.fas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fas.dto.ChatboxDto;

@Repository
public interface ChatboxDao extends JpaRepository<ChatboxDto, String> {

	public List<ChatboxDto> findBySellerId(String sellerId);
}
