package com.social.network.service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.network.dao.DatabaseHandler;
import com.social.network.model.UserProfile;

@RestController             //anotation
public class LoginController {

	
	DatabaseHandler dbHandler = new DatabaseHandler();
	
    @RequestMapping("/listallprofiles")
    public List<User> getUser(@RequestParam(value="name", defaultValue="World") String name) {
    	return dbHandler.getAllUser();
    }
    
	@RequestMapping("/userSignup")
	public User userSignup(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password) {
		DatabaseHandler dbHandler = new DatabaseHandler();
		User user = dbHandler.getUser(email, password);
		if(user!=null){
			return null;
		} 
		user = new User();
		user.setName(username);
		user.setEmail(email);
		user.setId(email);
		user.setPassword(password);
		UserProfile userProfile=new UserProfile();		
		userProfile.setId(email);
		userProfile.setProfileImage(email+"_image");
		userProfile.setUserName(username);
		dbHandler.saveUser(user);
		dbHandler.saveUserProfile(userProfile);
		return user;
    }
	
    @RequestMapping("/isValidUser")
    public UserProfile validateUser(@RequestParam(value="email") String email,@RequestParam(value="password") String password) {
    	DatabaseHandler dbHandler = new DatabaseHandler();
    	User user= dbHandler.getUser(email, password); 
    	if(user == null){
    		return null;
    	}
    	String id= user.getEmail();	
    	UserProfile userProfile = dbHandler.getUserProfile(id);    
    	return userProfile;
    }
    
    @RequestMapping("/getUserProfile")
    public UserProfile getUserProfile(@RequestParam(value="userId") String userId) {
    	DatabaseHandler dbHandler = new DatabaseHandler();
    	return dbHandler.getUserProfile(userId);
    }
    
    @RequestMapping("/AddImageOfUser")
    public User addImageUserProfile(@RequestParam(value="email") String email,@RequestParam(value="password") String password) {
    	DatabaseHandler dbHandler = new DatabaseHandler();
    	User user= dbHandler.getUser(email, password);   
    	dbHandler.saveUser(user);
    	return user;
    }
  
	@RequestMapping("/updateProfile")
	public UserProfile updateProfile(
			@RequestParam(value = "userId") String emailId,
			@RequestParam(value = "username") String username,
			@RequestParam(value = "birthday") String birthday,
			@RequestParam(value = "address") String address,
			@RequestParam(value = "state") String state,
			@RequestParam(value = "mobile") String mobile,
			@RequestParam(value = "emaild") String OtherEmailId,
			@RequestParam(value = "college") String college,
			@RequestParam(value = "degree") String degree,
			@RequestParam(value = "fieldOfStudy") String fieldOfStudy,
			@RequestParam(value = "activites") String activites,
			@RequestParam(value = "topSkills") String topSkills,
			
			@RequestParam(value = "company") String company,
			@RequestParam(value = "possition") String possition,
			@RequestParam(value = "companyCity") String companyCity,
			@RequestParam(value = "project") String project, 
			@RequestParam(value = "profileImage") String profileImage){
		
		DatabaseHandler dbHandler = new DatabaseHandler();
		UserProfile profile =dbHandler.getUserProfile(emailId);
		if(profile == null){
			profile = new UserProfile();
		}
		profile.setId(emailId);
		profile.setUserName(username);
		profile.setBirthday(birthday);
		profile.setAddress(address);
		profile.setMobile(mobile);
		profile.setEmailId(OtherEmailId);
		profile.setState(state);
		profile.setCollege(college);
		profile.setDegree(degree);
		profile.setFieldOfStudy(fieldOfStudy);
		profile.setActivites(activites);
		profile.setTopSkills(topSkills);
		profile.setCompany(company);
		profile.setPossition(possition);
		profile.setCompanyCity(companyCity);
		profile.setProject(project);
		profile.setProfileImage(profileImage);
		dbHandler.saveUserProfile(profile);

		return profile;
    }
	
	    
}


