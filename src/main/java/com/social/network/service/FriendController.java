package com.social.network.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.network.model.Friend;

@RestController
public class FriendController {

    @RequestMapping("/friendlist")
    public List<Friend> getFriendList(@RequestParam(value="name", defaultValue="World") String name) {
    	List<Friend> friends = new ArrayList<Friend>();
    	friends.add(new Friend("Sudama", " HMH" , "JP Morgan","sudama.jpeg"));
    	friends.add(new Friend("MP", " MP" , "JP Morgan","sudama.jpeg"));
    	friends.add(new Friend("Ashsish", " HMH" , "JP Morgan","ashish.jpeg"));	
    	friends.add(new Friend("Ashsish1", " HMH" , "JP Morgan","ashish.jpeg"));	    
    	friends.add(new Friend("Ashsish2", " HMH" , "JP Morgan","ashish.jpeg"));	    
    	friends.add(new Friend("Ashsish3", " HMH" , "JP Morgan","ashish.jpeg"));	    
    	return friends;
    }  
    
}
