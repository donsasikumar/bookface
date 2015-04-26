package com.dj.bf;

import java.util.ArrayList;
import java.util.Date;


public class User {

	private String userName;
	private String userHobby;
	
	private Long userMobile;
	private Date userDOB;
	private ArrayList<String> bookList;

	private Address userAddress;

	public Address getuserAddress() {
		return userAddress;
	}
	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}

	public Long getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(Long userMobile) {
		this.userMobile = userMobile;
	}
	public Date getUserDOB() {
		return userDOB;
	}
	public void setUserDOB(Date userDOB) {
		this.userDOB = userDOB;
	}
	public ArrayList<String> getUserSkills() {
		return bookList;
	}
	public void setUserSkills(ArrayList<String> bookList) {
		this.bookList = bookList;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserHobby() {
		return userHobby;
	}
	public void setUserHobby(String userHobby) {
		this.userHobby = userHobby;
	}
}
