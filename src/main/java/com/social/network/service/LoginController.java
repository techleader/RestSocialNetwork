package com.social.network.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController             //anotation
public class LoginController {

	    private static final String template = "Hello, %s!";
	    private final AtomicLong counter = new AtomicLong();

	    @RequestMapping("/userprofile")
	    public UserProfile greeting(@RequestParam(value="name", defaultValue="World") String name) {
	    	UserProfile userProfile =  new UserProfile();
	    	userProfile.setFirstName("Jawahar" );
	    	userProfile.setLastName("Nayak");
	    	userProfile.setId(counter.incrementAndGet());
	    	userProfile.setUserName("jawahar");
	    	userProfile.setPassword("pwd");
	    	return userProfile;
	    }
	    
  
	    
}


