package com.capgemini.librarymanagementsystem.dto;


import java.io.Serializable;

@SuppressWarnings("serial")
public class AdminBean implements Serializable {
	private int adminId;
	private String adminName;
	private String email;
	private Long phone;
	private String password;
	
	
	public AdminBean(int adminId, String adminName, String email, Long phone, String password) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	
	
	

	public AdminBean() {
		super();
	}




	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminBean [adminId=" + adminId + ", adminName=" + adminName + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + "]";
	}
	

}