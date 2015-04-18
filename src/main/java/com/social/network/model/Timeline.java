package com.social.network.model;

import java.util.Date;



public class Timeline {

	String userName;
	Date date;
	String image;
	String like;
	String comment;
	String Share;
	
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

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getShare() {
		return Share;
	}

	public void setShare(String share) {
		Share = share;
	}

	public Timeline(String userName,Date date,String image,String like,String comment,String Share){
		this.userName=userName;
		this.date=date;
		this.image=image;
		this.comment=comment;
		this.like=like;
		this.Share=Share;
	}


}
