package com.social.network.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;
import com.social.network.model.Timeline;
import com.social.network.service.UserProfile;


public class DatabaseHandler {
	
	private MongoOperations mongoOperation;
	
	public DatabaseHandler(){
		try {
/*			MongoTemplate mongoTemplate = new MongoTemplate( new SimpleMongoDbFactory(new MongoClient(), "yourdb"));
			mongoOperation = (MongoOperations)mongoTemplate;*/
			ApplicationContext ctx = new AnnotationConfigApplicationContext(
					com.social.network.config.SpringMongoConfig.class);
			 mongoOperation = (MongoOperations) ctx
					.getBean("mongoTemplate");

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void saveUserProfile(UserProfile userProfile) {
		mongoOperation.save(userProfile);
	}
	
	public void saveTimeline(Timeline timeline) {
		mongoOperation.save(timeline);
	}
	
	
	public Timeline getTimeLine(String timelineid) {		
		Query searchTimelineQuery = new Query(Criteria.where("id").is(timelineid));
		Timeline timeline = mongoOperation.findOne(searchTimelineQuery, Timeline.class);
		return timeline;		
	}
	
	public List<Timeline> getAllTimeLines() {		
		Query searchTimelineQuery = new Query();
		searchTimelineQuery.with(new Sort(Sort.Direction.DESC, "date"));
		List<Timeline> timelines = mongoOperation.find(searchTimelineQuery, Timeline.class);
		return timelines;		
	}
	
	public List<UserProfile> getAllUserProfiles() {
		Query searchUserQuery = new Query();
		//Criteria.where("username").is("Jawahar")
		// find the saved user again.
		List<UserProfile> savedUser = mongoOperation.find(searchUserQuery, UserProfile.class);
		return savedUser;
		
	}
	public boolean isValidUser(String username, String password){
		Query searchUserQuery = new Query(Criteria.where("firstName").is(username).
				and("password").is(password));
		//
		// find the saved user again.
		List<UserProfile> userFound = mongoOperation.find(searchUserQuery, UserProfile.class);
		if(userFound!=null && userFound.size()==1){
			return true;
		}else{
			return false;
		}
	}
}
