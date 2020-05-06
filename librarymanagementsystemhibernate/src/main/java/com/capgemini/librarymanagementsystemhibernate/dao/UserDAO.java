package com.capgemini.librarymanagementsystemhibernate.dao;


import java.util.List;

import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;
import com.capgemini.librarymanagementsystemhibernate.dto.BookBorrowBean;
import com.capgemini.librarymanagementsystemhibernate.dto.BookIssuseBean;
import com.capgemini.librarymanagementsystemhibernate.dto.BookRequestBean;
import com.capgemini.librarymanagementsystemhibernate.dto.UserBean;

public interface UserDAO {
	boolean register(UserBean user);
	UserBean login(String email,String password);
	boolean addBook(BookBean book);
	boolean removeBook(int bookId);
	boolean updateBook(BookBean book);
	boolean issueBook(int bookId,int userId);
	boolean request(int bookId, int userId);
	List<BookBorrowBean> borrowedBook(int userId);
	List<BookBean> searchBookById(int bookId);
	List<BookBean> searchBookByTitle(String bookName);
	List<BookBean> searchBookByAuthor(String bookAuthor);
	List<BookBean> getBooksInfo();
	boolean returnBook(int bookId,int userId,String status);
	List<BookIssuseBean> bookHistoryDetails(int userId);
	List<BookRequestBean> showRequests();
	List<BookIssuseBean> showIssuedBooks();
	List<UserBean> showUsers();
	boolean updatePassword(String email,String password,String newPassword,String role);
}
