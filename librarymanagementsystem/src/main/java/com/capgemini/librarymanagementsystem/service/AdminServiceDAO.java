package com.capgemini.librarymanagementsystem.service;


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
	LinkedList<BookBean> searchBookTitle(String bookName);
	LinkedList<BookBean> searchBookAuthor(String bookAuthor);
	LinkedList<BookBean> searchBookType(String bookType);
	boolean updateBook(int bookId);
	boolean removeBook(int bookId);
	LinkedList<Integer> getBookIds();
	LinkedList<BookBean> getBooksInfo();

	List<StudentBean> showUsers();
	List<RequestBean> showRequests();
	boolean bookIssue(StudentBean student,BookBean book);
	boolean isBookReceived(StudentBean student,BookBean book);
}