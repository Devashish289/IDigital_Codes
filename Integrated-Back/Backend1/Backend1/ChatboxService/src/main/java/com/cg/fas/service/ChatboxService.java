package com.cg.fas.service;

import java.util.List;

import com.cg.fas.dto.ChatboxDto;

public interface ChatboxService {

	public String addChat(ChatboxDto chat);
	public List<String> getChats(String SellerId,String buyerId);
	public String deleteChat(String sellerId, String buyerId);
}
