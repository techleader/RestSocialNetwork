package com.social.network.model;

public class Friend {
	
	String friendName;	

	public Friend(String friendName) {
		super();
		this.friendName = friendName;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

}
