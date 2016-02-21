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
import com.mongodb.WriteResult;
import com.social.network.model.Conversation;
import com.social.network.model.Timeline;
import com.social.network.model.UserProfile;
import com.social.network.service.User;


public class DatabaseHandler {
	
	private MongoOperations mongoOperation;
	
	public DatabaseHandler(){
		try {
/*			MongoTemplate mongoTemplate = new MongoTemplate( new SimpleMongoDbFactory(new MongoClient(), "yourdb"));
			mongoOperation = (MongoOperations)mongoTemplate;*/
			ApplicationContext ctx = new AnnotationConfigApplicationContext(com.social.network.config.SpringMongoConfig.class);
			 mongoOperation = (MongoOperations) ctx
					.getBean("mongoTemplate");

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void saveUser(User user) {
		mongoOperation.save(user);
	}
	public void saveUserProfile(UserProfile userProfile) {
		mongoOperation.save(userProfile);
	}
	
	public void saveTimeline(Timeline timeline) {
		mongoOperation.save(timeline);
	}
	
	public void saveConversation(Conversation conversation) {
		mongoOperation.save(conversation);
	}
	public Conversation getConversation(String user1_id,String user2_id){
		Query searchQuery = new Query(Criteria.where("user1_id").is(user1_id));
		searchQuery.addCriteria(Criteria.where("user2_id").is(user2_id));
		Conversation conversation=mongoOperation.findOne(searchQuery, Conversation.class);
		if(conversation == null){
			searchQuery = new Query(Criteria.where("user1_id").is(user2_id));
			searchQuery.addCriteria(Criteria.where("user2_id").is(user1_id));
			conversation=mongoOperation.findOne(searchQuery, Conversation.class);
		}
		return conversation;
	}
	
	public List<Conversation> getConversations(String user){
		Query searchQuery = new Query(Criteria.where("user1_id").is(user));
		//.elemMatch(Criteria.where("user2_id").is(user)));
		System.out.println(searchQuery.toString());
		List<Conversation> conversations=mongoOperation.find(searchQuery, Conversation.class);
		if(conversations==null || conversations.size()==0) {
			searchQuery = new Query(Criteria.where("user2_id").is(user));
		}
		conversations=mongoOperation.find(searchQuery, Conversation.class);
		return conversations;
	}
	public WriteResult deleteConversation(String id) {		
		Query deleteQuery = new Query(Criteria.where("id").is(id));
		return mongoOperation.remove(deleteQuery, Conversation.class);
		
	}
	
	public List<Conversation> getAllConversation() {		
		Query searchQuery = new Query();
		searchQuery.with(new Sort(Sort.Direction.DESC, "date"));
		List<Conversation> conversations = mongoOperation.find(searchQuery, Conversation.class);
		return conversations;		
	}
	
	public Conversation getConversationWithId(String conversation_id) {		
		Query searchQuery = new Query(Criteria.where("id").is(conversation_id));
		Conversation conversation = mongoOperation.findOne(searchQuery, Conversation.class);
		return conversation;		
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
	
	public List<User> getAllUser() {
		Query searchUserQuery = new Query();
		//Criteria.where("username").is("Jawahar")
		// find the saved user again.
		List<User> savedUser = mongoOperation.find(searchUserQuery, User.class);
		return savedUser;
		
	}
	public boolean isValidUser(String email, String password){
		User userporfile = getUser(email, password);
		if(userporfile!=null){
			return true;
		}else{
			return false;
		}
	}
	public User findUser(String user2){
		Query searchUserQuery = new Query(Criteria.where("id").is(user2));
		//				andOperator(Criteria.where("password").is(password)));
				//and("password").is(password));
		System.out.println(searchUserQuery.toString());
		return mongoOperation.findOne(searchUserQuery, User.class);		
	}
	
	public User getUser(String email, String password){
		Query searchUserQuery = new Query(Criteria.where("email").is(email));
		//				andOperator(Criteria.where("password").is(password)));
				//and("password").is(password));
		System.out.println(searchUserQuery.toString());
		return mongoOperation.findOne(searchUserQuery, User.class);		
	}
	
	public UserProfile getUserProfile(String emailId){
		Query searchUserQuery = new Query(Criteria.where("Id").is(emailId));
		//				andOperator(Criteria.where("password").is(password)));
				//and("password").is(password));
		System.out.println(searchUserQuery.toString());
		return mongoOperation.findOne(searchUserQuery, UserProfile.class);		
	}
}
