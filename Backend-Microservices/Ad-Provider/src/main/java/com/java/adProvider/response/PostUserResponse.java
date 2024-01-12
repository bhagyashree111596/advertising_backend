package com.java.adProvider.response;

public class PostUserResponse {

	   //private Long id;
	private String username;

    private boolean enabled;
    private String role;
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

	public PostUserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostUserResponse(String username, boolean enabled, String role) {
		super();
		this.username = username;
		this.enabled = enabled;
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserPojo [username=" + username + ", enabled=" + enabled + ", role=" + role + "]";
	}




}
