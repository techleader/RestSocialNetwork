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
    	friends.add(new Friend("Rahul Meena", "work at Girnar Technology" , "jaipur, India","rahul,kamina@gmail.com_image.jpg"));
    	friends.add(new Friend("Jawahar Nayak", "Software engineer at JP Morgan" , "Mumbai, India","jls.jpg"));
    	friends.add(new Friend("Anu nayak", "Resercher" , "Dhanbad,India","anu.jpg"));	
    	friends.add(new Friend("Rakesh Nayak", "work at Lipi data" , "Udaipur","rakesh.JPG"));	    
    	friends.add(new Friend("Dheeraj Nayak", "Cleark at Punjab National Bank" , "Udaipur","dk.jpg"));	    
    	friends.add(new Friend("Ashsish3", " HMH" , "JP Morgan","cool.jpg"));	    
    	friends.add(new Friend("Mansi Arora", "Student at Doon International School" , "Dehradun, India","maansi.jpg"));
    	
    	return friends;
    }  
    
}
