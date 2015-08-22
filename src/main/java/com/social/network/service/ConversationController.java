package com.social.network.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List; 
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.util.JSON;
import com.social.network.dao.DatabaseHandler;
import com.social.network.model.Comment;
import com.social.network.model.Conversation;
import com.social.network.model.Message;
import com.social.network.model.Timeline;
import com.social.network.model.UserProfile;

@RestController
public class ConversationController {
	
	 DatabaseHandler dbHandler =new DatabaseHandler();
	 
	 @RequestMapping("/getConversation")
	  public Conversation getConversation(@RequestParam(value="user1") String user1_id,
			  @RequestParam(value="user2") String user2_id){
		 return dbHandler.getConversation(user1_id, user2_id);
		  
	  }
	 @RequestMapping("/listUserConversations")
	  public List<Conversation> listConversations(@RequestParam(value="user") String user){
		 return dbHandler.getConversations(user);
		  
	  }
	 @RequestMapping("/getConversationWithId")
	  public Conversation getConversationWithId(@RequestParam(value="id") String conversation_id){
		 return dbHandler.getConversationWithId(conversation_id);
		  
	  }
	 
	 @RequestMapping("/listAllConversation")
	  public List<Conversation> listAllConversation(){
		 return dbHandler.getAllConversation();		  
	  }
	 
	  @RequestMapping("/listofUsersWithActiveConversation")
	  public List<String> listofUsersWithActiveConversation(@RequestParam(value="userid") String email){
		  List<Conversation> conversations = dbHandler.getConversations(email);	
		  List<String> listOfAnotherUser = new ArrayList<String>();
		  for(Conversation c : conversations){
			  if(email.equals(c.getUser1_id())){				  
				  listOfAnotherUser.add(c.getUser2_id());
			  } else {
				  listOfAnotherUser.add(c.getUser1_id());
			  }
					  
		  }
		 return  listOfAnotherUser;	  
	  }
	 
	 @RequestMapping("/addMessages")
	    public Conversation addMessages(@RequestParam(value="message") String message,
	    		@RequestParam(value="user1") String user1,
	    		@RequestParam(value="user2") String user2
	    	) {
		 	User user;
		 	Conversation conversation =dbHandler.getConversation(user1,user2);
		 	if(conversation==null){		 		
		 		conversation =new Conversation();
		 		conversation.setId(UUID.randomUUID().toString());
		 		conversation.setUser1_id(user1);
		 		conversation.setUser2_id(user2);
		 	}
	    	Message messageToBeadded =new Message();
	    	messageToBeadded.setSender_id(user1);	    	
	    	messageToBeadded.setText(message);	    	
	    	messageToBeadded.setSentTime(new Date());
	    	conversation.addMessage(messageToBeadded);
	    	dbHandler.saveConversation(conversation);
	    	return conversation;
	    }
	    
	 
}
