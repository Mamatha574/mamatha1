package com.capgemini.librarymanagementsystem.service;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dto.AdminBean;
import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.StudentBean;

public interface AdminServiceDAO {
	
	boolean register (AdminBean adm);
	AdminBean auth(String email,String password);
	boolean addBook(BookBean book);
	ArrayList<BookBean> searchBookTitle(String bookName);
	ArrayList<BookBean> searchBookAuthor(String bookAuthor);
	ArrayList<BookBean> searchBookType(String bookType);
	boolean removeBook(int bookId);
	ArrayList<Integer> getBookIds();
	ArrayList<BookBean> getBooksInfo();

	List<StudentBean> showUsers();
	List<RequestBean> showRequests();
	boolean bookIssue(StudentBean student,BookBean book);
	boolean isBookReceived(StudentBean student,BookBean book);
}