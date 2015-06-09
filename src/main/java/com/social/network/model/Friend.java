package com.social.network.model;

public class Friend {
	
	String friendName;	
	String livesAt;
	String worksAt;
	String image;

	public Friend(String friendName,String liveat, String workAt,String image) {
		super();
		this.friendName = friendName;
		this.livesAt = liveat;
		this.worksAt = workAt;
		this.image = image;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String getLivesAt() {
		return livesAt;
	}

	public void setLivesAt(String livesAt) {
		this.livesAt = livesAt;
	}

	public String getWorksAt() {
		return worksAt;
	}

	public void setWorksAt(String worksAt) {
		this.worksAt = worksAt;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
