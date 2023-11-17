package com.cg.fas.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="chatbox")
@Entity
public class ChatboxDto {
	@Id
	@Column(name="chat_id")
	private String chatId;
	@Column(name="seller_id")
	private String sellerId;
	@Column(name="buyer_id")
	private String buyerId;
	@Column(name="message")
	private String message;
	@Column(name="message_status")
	private String messageStatus;
	    
	public String getChatId() {
		return chatId;
	}
	public void setChatId(String chatId) {
		this.chatId = chatId;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageStatus() {
		return messageStatus;
	}
	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}
	public ChatboxDto(String chatId, String sellerId, String buyerId, String message, String messageStatus) {
		super();
		this.chatId = chatId;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.message = message;
		this.messageStatus = messageStatus;
	}
	public ChatboxDto() {
		super();
	}
	@Override
	public String toString() {
		return "ChatboxDto [chatId=" + chatId + ", sellerId=" + sellerId + ", buyerId=" + buyerId + ", message="
				+ message + ", messageStatus=" + messageStatus + "]";
	}
	
}
