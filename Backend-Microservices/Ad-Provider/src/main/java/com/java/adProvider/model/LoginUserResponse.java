package com.java.adProvider.model;

public class LoginUserResponse {

	private String token;

	public LoginUserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginUserResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
