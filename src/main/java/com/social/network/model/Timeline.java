package com.social.network.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Timelines")
public class Timeline {

	String id;
	String userName;
	Date date;
	String image;
	String status;
	private List<String> userLikes=new ArrayList<String>();
	List<Comment> comments;
	
	public String getId() {
		return id;
	}

	public void setTimelineId(String timelineId) {
		this.id = timelineId;
	}
	
	public String getStatus() {
		return status;
	}

	public List<Comment> getComments() {
		return comments;
	}
	public Comment getComment(String commentid) {
		for(int i=0;i<comments.size();i++){
			Comment comment = comments.get(i);				
			if(comment.getId()!=null && comment.getId().equals(commentid)) {
				return comment;
			}				
		}	
		return null;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void addComment(Comment comment) {
		if(comments==null){
			comments = new ArrayList<Comment>();
		}
		comments.add(comment);
	}
	
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	public List<String> getUserLikes() {
		return userLikes;
	}

	public void setUserLikes(List<String> userLikes) {
		this.userLikes = userLikes;
	}

	public void addUserLike(String username) {
		userLikes.add(username);
	}
}
