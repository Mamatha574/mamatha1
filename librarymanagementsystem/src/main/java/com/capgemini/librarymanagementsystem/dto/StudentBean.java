package com.capgemini.librarymanagementsystem.dto;


import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class StudentBean implements Serializable {
	private int studentId;
	private String studentName;
	private String email;
	private String password;
	private String sdepartment;
	private long phone;
	private Date issueDate;
	private Date returnDate;
	private int booksBorrowed;

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSdepartment() {
		return sdepartment;
	}
	public void setSdepartment(String sdepartment) {
		this.sdepartment = sdepartment;
	}
	
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public int getBooksBorrowed() {
		return booksBorrowed;
	}
	public void setBooksBorrowed(int booksBorrowed) {
		this.booksBorrowed = booksBorrowed;
	}





}