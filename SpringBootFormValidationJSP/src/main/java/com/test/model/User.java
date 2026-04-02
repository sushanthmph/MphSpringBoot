package com.test.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class User {
	@NotEmpty(message="username required")
	@Size(min=3 ,max=15 )
	private String username;
	
	@NotEmpty(message="password required")
	@Size(min=8 ,max=15 )
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
