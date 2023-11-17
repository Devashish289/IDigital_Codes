package com.cg.fas.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fas.dto.ChatboxDto;
import com.cg.fas.service.ChatboxService;

@RestController
public class ChatboxController {
	
	@Autowired
	ChatboxService chatService;
	 Logger logger = LoggerFactory.getLogger(this.getClass());

	 
	 @PostMapping(value= "addChat")
		public String addChat(@RequestBody ChatboxDto chat)
		{
			 logger.info("Adding chats to the database");
			return chatService.addChat(chat);
		}
	 
	@GetMapping(value = "getChats/{sellerId}/{buyerId}")
	public List<String> getChats(@PathVariable String sellerId,@PathVariable String buyerId)
	{
		 logger.info("Displaying Chats for this user");
		return chatService.getChats(sellerId, buyerId);
	}
	
	@DeleteMapping(value= "deleteChat/{sellerId}/{buyerId}")
	public String deleteChat(@PathVariable String sellerId, @PathVariable String buyerId)
	{
		logger.info("Deleting Chats from Database");
		return chatService.deleteChat(sellerId, buyerId);
	}
}
