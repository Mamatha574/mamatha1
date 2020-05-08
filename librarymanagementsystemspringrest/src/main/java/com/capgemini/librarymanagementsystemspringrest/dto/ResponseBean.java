package com.capgemini.librarymanagementsystemspringrest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBean {
	private boolean error;
	private String message;
	
	private UserBean userBean;
	private BookBean bookBean;
	private BookIssuseBean bookIssuseDetails;
	private BookBorrowBean bookBorrowBean;
	private BookRequestBean bookRequestBean;
	
	private List<UserBean> userBean1;
	private List<BookBean> bookBean1;
	private List<BookIssuseBean> bookIssuseDetails1;
	private List<BookBorrowBean> bookBorrowBean1;
	private List<BookRequestBean> bookRequestBean1;
	
	
}
