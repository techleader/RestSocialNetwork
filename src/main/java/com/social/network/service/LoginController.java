package com.social.network.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.network.model.Friend;

@RestController
public class LoginController {

	    private static final String template = "Hello, %s!";
	    private final AtomicLong counter = new AtomicLong();

	    @RequestMapping("/userprofile")
	    public UserProfile greeting(@RequestParam(value="name", defaultValue="World") String name) {
	    	UserProfile userProfile =  new UserProfile();
	    	userProfile.setFirstName("Jawahar");
	    	userProfile.setLastName("Nayak");
	    	userProfile.setId(counter.incrementAndGet());
	    	userProfile.setUserName("jawahar");
	    	userProfile.setPassword("pwd");
	    	return userProfile;
	    }
	    
	    @RequestMapping("/friendlist")
	    public List<Friend> getFriendList(@RequestParam(value="name", defaultValue="World") String name) {
	    	List<Friend> friends = new ArrayList<Friend>();
	    	friends.add(new Friend("Sudama"));
	    	friends.add(new Friend("MP"));
	    	friends.add(new Friend("ashsish"));	    	
	    	return friends;
	    }
}


