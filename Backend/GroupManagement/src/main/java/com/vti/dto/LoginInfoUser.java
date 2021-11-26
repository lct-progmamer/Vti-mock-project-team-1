package com.vti.dto;

public class LoginInfoUser {

	private String token;

	private String userName;

	private String sdt;
	
	private String email;

	private String firstName;

	private String lastName;

	private String role;

	private String status;
	
	private String avatarUrl;
	
	
	

	public LoginInfoUser() {
		super();
	}

	public LoginInfoUser(String token, String userName, String sdt, String email, String firstName, String lastName,
			String role, String status , String avatarUrl) {
		super();
		this.token = token;
		this.userName = userName;
		this.sdt = sdt;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.status = status;
		this.avatarUrl = avatarUrl;
	}

	public String getToken() {
		return token;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getRole() {
		return role;
	}

	public String getStatus() {
		return status;
	}

	public String getSdt() {
		return sdt;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	
}
