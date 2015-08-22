package com.social.network.test;

import org.junit.Assert;
import org.junit.Test;

import com.social.network.dao.DatabaseHandler;
import com.social.network.model.UserProfile;
import com.social.network.service.LoginController;
import com.social.network.service.User;

public class LoginControllerTest {
/*	
	@Test
	public void testSignup(){
		LoginController loginCtrl = new LoginController();
		User user = loginCtrl.userSignup("Dummy Nayak", "dummy@gmail.com", "jls");
		Assert.assertNotNull(user);
		DatabaseHandler dbHandler = new DatabaseHandler();
		UserProfile profile = dbHandler.getUserProfile("dummy@gmail.com");
		Assert.assertNotNull(profile);
		Assert.assertEquals("dummy@gmail.com", profile.getId());
		Assert.assertEquals(null, profile.getUserName());		
		user = loginCtrl.userSignup("Dummy Nayak", "dummy@gmail.com", "jls");		
		Assert.assertNull(user);	
		loginCtrl.userSignup("Jawahar Nayak", "dummy@gmail.com", "jls");
		profile = dbHandler.getUserProfile("dummy@gmail.com");
		Assert.assertNotNull(profile);
		Assert.assertEquals("Jawahar Nayak", profile.getUserName());
		//dbHandler.deleteUser("dummy");
		//dbHandler.deleteUserProfile("dummy");
	}
	*/
	/*@Test
	public void addUser(){
		LoginController loginCtrl = new LoginController();	
		User user = loginCtrl.userSignup("Rahul Meena", "rahu1.kamina@gmail.com", "meena");
		user = loginCtrl.userSignup("Murari Bohra", "murari.pujari@gmail.com", "madari");
		user = loginCtrl.userSignup("Ravi Choudhary", "ravi.kitti@gmail.com", "ravida");
		user = loginCtrl.userSignup("Anil", "anil.kumar@gmail.com", "anil");
		
	}*/
	
	@Test
	public void updateUserProfile(){
		LoginController loginCtrl = new LoginController();	
		UserProfile profile= loginCtrl.updateProfile("rahul.kamina@gmail.com","Rahul Meena","26-july-1991","kota",
				"Rajasthan","","rajnayak91@gmail.com","University of Kota","MCA",
				"Infromation technology","","",
				" Genx Soft. Technologies Pvt.Ltd","Trainee","mumbai","","rahul.kamina@gmail.com_image.jpg");
				Assert.assertNotNull(profile);
	
		/*DatabaseHandler dbHandler = new DatabaseHandler();
		UserProfile profil = dbHandler.getUserProfile("sanjana@gmail.com");
		profil.setProfileImage("rahul.kamina@gmail.com_image.jpg");
		dbHandler.saveUserProfile(profile);
		profile = dbHandler.getUserProfile("jlsnayak1983@gmail.com");
		profile.setProfileImage("jlsnayak1983@gmail.com_image.jpg");
		dbHandler.saveUserProfile(profile);
		profile = dbHandler.getUserProfile("rjnayak91@gmail.com");
		profile.setProfileImage("rjnayak91@gmail.com_image.jpg");
		dbHandler.saveUserProfile(profile);
*/
	}

}
