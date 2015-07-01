package com.social.network.service;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User {
	    private String id;
	    private String name;
	    private String email;
	    private String password;
 	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
}


