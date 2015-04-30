package com.ndj.pojo;

import java.util.Arrays;

public class userdata {
	protected String userName;
	protected String password;
	protected String email;
	protected String[] books;
	protected String[] authors;
	
	
	public userdata(String userName, String password, String email,
			String[] books, String[] authors) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.books = books;
		this.authors = authors;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String[] getBooks() {
		return books;
	}
	public void setBooks(String[] books) {
		this.books = books;
	}
	public String[] getAuthors() {
		return authors;
	}
	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
	@Override
	public String toString() {
		return userName + "|" + password
				+ "|" + email + "|" + Arrays.toString(books)
				+ "|" + Arrays.toString(authors);
	}
	
	

}
