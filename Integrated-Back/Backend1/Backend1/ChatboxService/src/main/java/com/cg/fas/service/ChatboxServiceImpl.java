package com.cg.fas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fas.dao.ChatboxDao;
import com.cg.fas.dto.ChatboxDto;

@Service
public class ChatboxServiceImpl implements ChatboxService {
	
	@Autowired
	ChatboxDao dao;
	
	@Override
	public String addChat(ChatboxDto chat) {
		ChatboxDto savedChat= dao.save(chat);
		if(savedChat!=null)
		{
			return "Chats Added";
		}
		return "Failure";
	}
	
	@Override
	public List<String> getChats(String sellerId, String buyerId) {
		List<ChatboxDto>list = dao.findBySellerId(sellerId);
		List<String> messagesList = new ArrayList<>();
		for(ChatboxDto chat : list)
		{
			if(chat.getBuyerId().equals(buyerId))
			{
				messagesList.add(chat.getMessage());
			}
		}
		return messagesList;
	}
	
	@Override
	public String deleteChat(String sellerId, String buyerId) {
		List<ChatboxDto>list = dao.findBySellerId(sellerId);
		for(ChatboxDto chat : list)
		{
			if(chat.getBuyerId().equals(buyerId))
			{
				dao.delete(chat);
			}
		}
		return "Chat deleted";
	}

}
