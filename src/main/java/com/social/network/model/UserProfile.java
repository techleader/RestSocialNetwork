package com.social.network.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserProfile")
public class UserProfile {
	String id;
	String userName;
	String birthday;
	String address;
	String state;
	String mobile;
	String emailId;
	String college;
	String degree;
	String fieldOfStudy;
	String activites;
	String topSkills;
	String company;
	String possition;
	String companyCity;
	String project;
	String profileImage;
	
	public String getMobile() {
		return mobile;
	}
	public String getEmailId() {
		return emailId;
	}
	public String getProject() {
		return project;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getAddress() {
		return address;
	}
	
	public String getState() {
		return state;
	}
	public String getCollege() {
		return college;
	}
	public String getDegree() {
		return degree;
	}
	public String getFieldOfStudy() {
		return fieldOfStudy;
	}
	public String getActivites() {
		return activites;
	}
	public String getTopSkills() {
		return topSkills;
	}
	
	public String getCompany() {
		return company;
	}
	public String getPossition() {
		return possition;
	}
	public String getCompanyCity() {
		return companyCity;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}
	public void setActivites(String activites) {
		this.activites = activites;
	}
	public void setTopSkills(String topSkills) {
		this.topSkills = topSkills;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	public void setPossition(String possition) {
		this.possition = possition;
	}
	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
}
