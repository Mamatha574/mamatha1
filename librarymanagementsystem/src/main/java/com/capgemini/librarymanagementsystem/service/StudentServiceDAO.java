package com.capgemini.librarymanagementsystem.service;


import java.util.ArrayList;

import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.StudentBean;

public interface StudentServiceDAO {
	
	boolean register (StudentBean std);
	StudentBean auth(String email,String password);
	ArrayList<BookBean> searchBookTitle(String bookName);
	ArrayList<BookBean> searchBookAuthor(String bookAuthor);
	ArrayList<BookBean> searchBookType(String bookType);
	ArrayList<Integer> getBookIds();
	ArrayList<BookBean> getBooksInfo();
	public RequestBean bookRequest(StudentBean student, BookBean book);
	public RequestBean bookReturn(StudentBean student, BookBean book);
	
}