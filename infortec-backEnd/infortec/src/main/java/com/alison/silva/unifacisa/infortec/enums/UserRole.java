package com.alison.silva.unifacisa.infortec.enums;

public enum UserRole {
	CLIENT("client"),
	ADMIN("employee");
	private String role;
	
	UserRole(String role) {
		// TODO Auto-generated constructor stub
		this.role = role;
	}

	public String getRole() {
		return role;
	}

}
