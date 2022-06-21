package com.javatraining.model;

import java.io.*;

public class User implements Serializable{
	
	private static final long serialVersionUID = 101L;
	private String userName;
	private String password;
	public User() {
		super();
		
	}
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}
	
	public boolean validate() {
		boolean result =false;
		if(userName.equals("india") && password.equals("india")) {
			return true;
		}
		return result;
	}
	
	
	
	

}
