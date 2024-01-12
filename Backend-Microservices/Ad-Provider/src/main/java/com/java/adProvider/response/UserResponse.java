package com.java.adProvider.response;

public class UserResponse {
	private String username;

    private boolean enabled;
    private String role;
    //private String password;
    private String phone;
    private String email;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserResponse(String username, boolean enabled, String role, String phone, String email) {
		super();
		this.username = username;
		this.enabled = enabled;
		this.role = role;
		this.phone = phone;
		this.email = email;
	}


}
