package com.social.network.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.network.dao.DatabaseHandler;

@RestController
public class ProfileController {
	
    @RequestMapping("/listallprofiles")
    public List<UserProfile> getTimelines(@RequestParam(value="name", defaultValue="World") String name) {
    	DatabaseHandler dbHandler = new DatabaseHandler();
    	return dbHandler.getAllUserProfiles();

    }

}
