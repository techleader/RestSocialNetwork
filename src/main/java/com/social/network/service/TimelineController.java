package com.social.network.service;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.social.network.dao.DatabaseHandler;
import com.social.network.model.Comment;
import com.social.network.model.Timeline;

@RestController
public class TimelineController {

	DatabaseHandler dbHandler = new DatabaseHandler();
	
    @RequestMapping("/listAllTimeLines")
    public List<Timeline> listAllTimelines() {    	
    	return dbHandler.getAllTimeLines();
    	
    }  
    /*@RequestMapping(value = "/addTimeLine", method = RequestMethod.POST)	
    public  @ResponseBody String addTimeLine( @RequestBody Timeline timeline ) {
    	return timeline.getStatus() + timeline.getUserName();
    }*/
    
    @RequestMapping(value="/addTimeLine", method = RequestMethod.GET)
    public Timeline addTimeLine(@RequestParam(value="status") String status,
    		@RequestParam(value="username") String username
    		) {
    	Timeline timeline = new Timeline();
    	timeline.setTimelineId(UUID.randomUUID().toString());
    	timeline.setStatus(status);
    	timeline.setUserName(username);
    	//timeline.setImage("333.jpg");
    	timeline.setDate(Calendar.getInstance().getTime());
    	dbHandler.saveTimeline(timeline);
    	return timeline;
    }
    
    @RequestMapping("/addImage")
    public Timeline addImage(@RequestParam(value="username") String username
    		) {
    	Timeline timeline = new Timeline();
    	String id=UUID.randomUUID().toString();
    	timeline.setTimelineId(UUID.randomUUID().toString());
    	timeline.setUserName(username);
    	timeline.setImage(id+"-image");
    	timeline.setDate(Calendar.getInstance().getTime());
    	dbHandler.saveTimeline(timeline);
    	return timeline;
    }
  
    @RequestMapping("/addCommentToTimeline")
    public Timeline addCommentToTimeLine(@RequestParam(value="comment") String comment,
    		@RequestParam(value="username") String username,
    		@RequestParam(value="timelineid") String timelineid
    	) {
    	Timeline timeline =dbHandler.getTimeLine(timelineid);
    	Comment commentToBeAdded = new Comment();
    	commentToBeAdded.setId(UUID.randomUUID().toString());
    	commentToBeAdded.setText(comment);
    	timeline.addComment(commentToBeAdded);
    	dbHandler.saveTimeline(timeline);
    	return timeline;
    }
    
    
    @RequestMapping("/likeComment")
    public Timeline likeComment(@RequestParam(value="commentid") String commentid,
    		@RequestParam(value="timelineid") String timelineid,
    		@RequestParam(value="username") String username    		
    	) {
    	Timeline timeline =dbHandler.getTimeLine(timelineid);
    	Comment commentTobeUpdated = timeline.getComment(commentid);
    	commentTobeUpdated.addUserLike(username);
    	dbHandler.saveTimeline(timeline);
    	return timeline;
    }
    
    @RequestMapping("/likeTimeline")
    public Timeline likeTimeline(@RequestParam(value="timelineid") String timelineid,
    		@RequestParam(value="username") String username    		
    	){
    		Timeline timeline =dbHandler.getTimeLine(timelineid);
    		timeline.addUserLike(username);
    		dbHandler.saveTimeline(timeline);
    		return timeline;
   		}
 }
