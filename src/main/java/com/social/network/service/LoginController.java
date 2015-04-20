package com.social.network.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.network.dao.DatabaseHandler;

@RestController             //anotation
public class LoginController {

	    @RequestMapping("/isValidUser")
	    public boolean addUserProfile(@RequestParam(value="username") String username,@RequestParam(value="password") String password) {
	    	DatabaseHandler dbHandler = new DatabaseHandler();
	    	return dbHandler.isValidUser(username,password);    
	    	
	    }
	    
  
	    
}


