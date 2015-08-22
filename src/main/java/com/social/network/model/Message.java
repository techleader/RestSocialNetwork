package com.social.network.model;

import java.util.Date;

public class Message {
	 private String sender_id;
	 private String text;
	 private Date sentTime;
  
	public String getSender_id() {
		return sender_id;
	}
	public String getText() {
		return text;
	}
	public Date getSentTime() {
		return sentTime;
	}
	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setSentTime(Date sentTime) {
		this.sentTime = sentTime;
	}

  
}
