package com.exam.todoapp.models;

import java.io.Serializable;

public class UserDTO implements Serializable{
	

	private static final long serialVersionUID = -1498449629080946101L;
	
		
	private String token;
	private User user;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserDTO(String token, User user) {
		super();
		this.token = token;
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserDTO [token=" + token + ", user=" + user + "]";
	}
	
	

}
