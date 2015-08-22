package com.social.network.test;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.social.network.dao.DatabaseHandler;
import com.social.network.model.Conversation;
import com.social.network.model.Message;

public class TestSteps {
	
	boolean isvalid ;
	com.social.network.model.Conversation conversation;

	int carea = 0;
	@Given("$username and $password user details")
//	@Aliases(values={"a new game: $width by $height"})
	public void givenTwoValue(String username,String password){
		DatabaseHandler dbHandler = new DatabaseHandler();
		isvalid = dbHandler.isValidUser(username, password);
	}
	
	@Then("it should be authenticated")
	public void showArea(){
		//Assert.assertTrue(isvalid);
	}

	@Given("$user1 and $user2 have conversation")
	public void ifTwoUsersHaveConversation(String user1,String user2){
		conversation = new com.social.network.model.Conversation();
		conversation.setId("123");
		conversation.setUser1_id(user1);
		conversation.setUser2_id(user2);
		
	
	}
	
	
	@When("$user1 sends $message to $user2")
	public void whenUserSendsMessage(String user1, String message,String user2){
		Message msg = new Message();
		msg.setSender_id(user1);
		msg.setSentTime(new Date());
		msg.setText(message);
		conversation.addMessage(msg);
		DatabaseHandler dbHandler = new DatabaseHandler();
		dbHandler.saveConversation(conversation);
		//When raj sends HI to jls
	}
	
	@Then("$user1 should see $message from $user2")
	public void userShouldSeeMessage(String user1,String message, String user2){
		DatabaseHandler dbHandler = new DatabaseHandler();
		Conversation conversation =dbHandler.getConversation(user1,user2);
		List<Message> messages =  conversation.getMessages();
		boolean messageExist = false;
		for(Message m : messages){
			if(message.equals(m.getText())){
				messageExist = true; 
				Assert.assertEquals(user2,m.getSender_id());
			}
		}
		org.junit.Assert.assertTrue(messageExist);
		

	}
			

}
