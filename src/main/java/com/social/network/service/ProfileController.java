package com.social.network.service;

import java.util.List;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.network.dao.DatabaseHandler;

@RestController
public class ProfileController {
	
	DatabaseHandler dbHandler = new DatabaseHandler();
	
    @RequestMapping("/listallprofiles")
    public List<UserProfile> getTimelines(@RequestParam(value="name", defaultValue="World") String name) {
    	return dbHandler.getAllUserProfiles();
    }
    
	@RequestMapping("/addUserProfile")
	public UserProfile addUserProfile(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password) {
		DatabaseHandler dbHandler = new DatabaseHandler();
		UserProfile userProfile = new UserProfile();
		userProfile.setFirstName(username);
		userProfile.setEmail(email);
		userProfile.setId(email);
		userProfile.setPassword(password);
		dbHandler.saveUserProfile(userProfile);
		return userProfile;
    }
    
    @RequestMapping("/userprofile")
    public UserProfile greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	UserProfile userProfile =  new UserProfile();
    	userProfile.setFirstName("Jawahar" );
    //	userProfile.setLastName("Nayak");
    	userProfile.setId(UUID.randomUUID().toString());
    	//userProfile.setUserName("jawahar");
    	userProfile.setPassword("pwd");
    	return userProfile;
    }

}
