package com.capgemini.librarymanagementsystemjdbc.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.BookBorrow;
import com.capgemini.librarymanagementsystemjdbc.dto.BookIssuse;
import com.capgemini.librarymanagementsystemjdbc.dto.BookRequest;
import com.capgemini.librarymanagementsystemjdbc.dto.User;

public interface UserDAO {
	boolean register(User user);
	User login(String email,String password);
	boolean addBook(BookBean book);
	boolean removeBook(int bookId);
	boolean updateBook(BookBean book);
	boolean issueBook(int bookId,int userId);
	boolean request(int bookId, int userId);
	List<BookBorrow> borrowedBook(int userId);
	LinkedList<BookBean> searchBookById(int bookId);
	LinkedList<BookBean> searchBookByTitle(String bookName);
	LinkedList<BookBean> searchBookByAuthor(String bookAuthor);
	LinkedList<BookBean> getBooksInfo();
	boolean returnBook(int bookId,int userId,String status);
	LinkedList<BookIssuse> bookHistoryDetails(int userId);
	LinkedList<BookRequest> showRequests();
	LinkedList<BookIssuse> showIssuedBooks();
	LinkedList<User> showUsers();
	boolean updatePassword(String email,String password,String newPassword,String role);
}

