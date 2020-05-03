package com.capgemini.librarymanagementsystem.service;


import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.StudentBean;

public interface StudentServiceDAO {
	
	boolean register (StudentBean std);
	StudentBean auth(String email,String password);
	LinkedList<BookBean> searchBookTitle(String bookName);
	LinkedList<BookBean> searchBookAuthor(String bookAuthor);
	LinkedList<BookBean> searchBookType(String bookType);
	LinkedList<Integer> getBookIds();
	LinkedList<BookBean> getBooksInfo();
	public RequestBean bookRequest(StudentBean student, BookBean book);
	public RequestBean bookReturn(StudentBean student, BookBean book);
	
}