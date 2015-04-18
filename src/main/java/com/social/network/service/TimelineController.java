package com.social.network.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.network.model.Post;
import com.social.network.model.Timeline;

@RestController
public class TimelineController {

    @RequestMapping("/timelines")
    public List<Timeline> listAllTimelines() {    	
    	List<Timeline> timelines = new ArrayList<Timeline>(); 
    	Timeline timeline =new Timeline("rajesh",new Date(),"sudama.jpeg","5","comment","share");
    	timelines.add(timeline);    	
    	return timelines;
    	
    }  
    
    @RequestMapping("/timeline")
    public Post getTimelines(@RequestParam(value="name", defaultValue="World") String name) {
    	Post post = new Post();
    	post.setPostId("IIIII");
    	post.setComment("I am feeling good");
    	post.setTimestamp(new Date());    	
    	return post;
    }
    
    @RequestMapping("/timelinesmap")
    public Map<String,Timeline> mapAllTimelines() {    	
    	List<Timeline> timelines = new ArrayList<Timeline>(); 
    	Timeline timeline =new Timeline("jai",new Date(),"sudama.jpeg","5","comment","share");
    	timelines.add(timeline);    	
    	
    	Map<String, Timeline> map = new HashMap<String, Timeline>();
    	map.put("jawahar", timeline);
    	
    	Timeline timeline2 =new Timeline("rajesh",new Date(),"sudama.jpeg","5","comment","share");
    	map.put("rajesh", timeline2);
    	
    	map.get("jawahar");
    	return map;
    	
    }  
}
