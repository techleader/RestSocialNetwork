package com.social.network.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.social.network.service.UserProfile;


public class DatabaseHandler {
	
	private MongoOperations mongoOperation;
	
	public DatabaseHandler(){
		try {
			ApplicationContext ctx = new AnnotationConfigApplicationContext(
					com.social.network.config.SpringMongoConfig.class);
			 mongoOperation = (MongoOperations) ctx
					.getBean("mongoTemplate");

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
/*	private MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(), "yourdb");
	}
 
	private MongoTemplate mongoTemplate() throws Exception { 
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory()); 
		return mongoTemplate; 
	}*/
	
	
	public void saveUserProfile(UserProfile userProfile) {
		mongoOperation.save(userProfile);
	}
	
	public List<UserProfile> getAllUserProfiles() {
		Query searchUserQuery = new Query();
		// find the saved user again.
		List<UserProfile> savedUser = mongoOperation.find(searchUserQuery, UserProfile.class);
		return savedUser;
		
	}

}
