package com.capgemini.librarymanagementsystemjdbc.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.BookBorrowBean;
import com.capgemini.librarymanagementsystemjdbc.dto.BookIssuseBean;
import com.capgemini.librarymanagementsystemjdbc.dto.BookRequestBean;
import com.capgemini.librarymanagementsystemjdbc.dto.UserBean;

public interface UserDAO {
	boolean register(UserBean user);
	UserBean login(String email,String password);
	boolean addBook(BookBean book);
	boolean removeBook(int bookId);
	boolean updateBook(BookBean book);
	boolean issueBook(int bookId,int userId);
	boolean request(int bookId, int userId);
	List<BookBorrowBean> borrowedBook(int userId);
	LinkedList<BookBean> searchBookById(int bookId);
	LinkedList<BookBean> searchBookByTitle(String bookName);
	LinkedList<BookBean> searchBookByAuthor(String bookAuthor);
	LinkedList<BookBean> getBooksInfo();
	boolean returnBook(int bookId,int userId,String status);
	LinkedList<BookIssuseBean> bookHistoryDetails(int userId);
	LinkedList<BookRequestBean> showRequests();
	LinkedList<BookIssuseBean> showIssuedBooks();
	LinkedList<UserBean> showUsers();
	boolean updatePassword(String email,String password,String newPassword,String role);
}

