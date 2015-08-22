package com.social.network.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import com.social.network.dao.DatabaseHandler;
import com.social.network.model.Conversation;
import com.social.network.model.UserProfile;
import com.social.network.service.ConversationController;
import com.social.network.service.LoginController;


public class ConversationTests {
	
	@Test
	public void testListConversation(){
		ConversationController ctrl = new ConversationController();		
		Conversation c = ctrl.addMessages("Hi Bhabhi", "Dummy1", "Dummy2");
		c = ctrl.addMessages("Hello Rajesh how r u", "Dummy2","Dummy1");		
		DatabaseHandler dbHandler = new DatabaseHandler();
		Conversation conversations = ctrl.getConversation("Dummy1","Dummy3");
		Assert.assertNull(conversations);
		conversations = ctrl.getConversation("Dummy1","Dummy2");
		Assert.assertNotNull(conversations);
		Assert.assertEquals(2, conversations.getMessages().size());
		
		dbHandler.deleteConversation(c.getId());
		Assert.assertNull(ctrl.getConversationWithId(c.getId()));		
		Assert.assertEquals(0, dbHandler.getConversations("Dummy1").size());
		Assert.assertEquals(0, dbHandler.getConversations("Dummy2").size());
	}
	
	@Test
	public void testMultipleConversation(){
		ConversationController ctrl = new ConversationController();		
		Conversation c = ctrl.addMessages("Hi Bhabhi", "rjnayak91@gmail.com", "sanjana@gmail.com");
		c = ctrl.addMessages("Hello Rajesh how r u", "sanjana@gmail.com","rjnayak91@gmail.com");		
		DatabaseHandler dbHandler = new DatabaseHandler();
		List<Conversation> conversations = dbHandler.getConversations("rjnayak91@gmail.com");
		Assert.assertNotNull(conversations);
		Assert.assertEquals(2, conversations.size());
		dbHandler.deleteConversation(c.getId());
		Assert.assertNull(ctrl.getConversationWithId(c.getId()));		
	}

	@Test
	public void testJustForAddingData(){
		ConversationController ctrl = new ConversationController();		
		Conversation c = ctrl.addMessages("Hi Rahul..Have u completed project?", "rjnayak91@gmail.com", "rahul.meena@gmail.com");
		c = ctrl.addMessages("Hi rajesh...No yar...Something is remaining", "rahul.meena@gmail.com","rjnayak91@gmail.com");		
	}

}
