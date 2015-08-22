package com.social.network.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comment {

	private String id;
	private String text;
	private String username;
	private Date commentTime;
	
	private String userId;
	private List<String> userLikes=new ArrayList<String>();
	
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		commentTime = commentTime;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<String> getUserLikes() {
		return userLikes;
	}
	public void setUserLikes(List<String> userLikes) {
		this.userLikes = userLikes;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void addUserLike(String username) {
		userLikes.add(username);
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
