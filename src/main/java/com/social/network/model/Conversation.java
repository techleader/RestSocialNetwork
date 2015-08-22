package com.social.network.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Conversation")
public class Conversation {
	String id;
	String user1_id;
    String user2_id;
	private List<Message> messages=new ArrayList<Message>();
	
	public String getId() {
		return id;
	}
	public String getUser1_id() {
		return user1_id;
	}
	public String getUser2_id() {
		return user2_id;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setUser1_id(String user1_id) {
		this.user1_id = user1_id;
	}
	public void setUser2_id(String user2_id) {
		this.user2_id = user2_id;
	}
	public void addMessage(Message message) {
		this.messages.add(message);
	}

}
