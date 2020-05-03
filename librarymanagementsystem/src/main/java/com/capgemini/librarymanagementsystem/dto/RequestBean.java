package com.capgemini.librarymanagementsystem.dto;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class RequestBean implements Serializable {
	private BookBean bookInfo;
	private StudentBean studentInfo;
	private boolean isIssued;
	private boolean isReturned;
	private Date issuedDate;
	private Date returnedDate;
	private Date expectedReturnedDate;
	public BookBean getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(BookBean bookInfo) {
		this.bookInfo = bookInfo;
	}
	public StudentBean getStudentInfo() {
		return studentInfo;
	}
	public void setStudentInfo(StudentBean studentInfo) {
		this.studentInfo = studentInfo;
	}
	public boolean isIssued() {
		return isIssued;
	}
	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}
	public boolean isReturned() {
		return isReturned;
	}
	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	public Date getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}
	public Date getExpectedReturnedDate() {
		return expectedReturnedDate;
	}
	public void setExpectedReturnedDate(Date expectedReturnedDate) {
		this.expectedReturnedDate = expectedReturnedDate;
	}
}