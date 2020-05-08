package com.capgemini.librarymanagementsystemspringrest.service;

import java.util.List;

import com.capgemini.librarymanagementsystemspringrest.dto.BookBean;
import com.capgemini.librarymanagementsystemspringrest.dto.BookBorrowBean;
import com.capgemini.librarymanagementsystemspringrest.dto.BookIssuseBean;
import com.capgemini.librarymanagementsystemspringrest.dto.BookRequestBean;
import com.capgemini.librarymanagementsystemspringrest.dto.UserBean;

public interface UserService {

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
	List<Integer> bookHistoryDetails(int userId);
	List<BookRequestBean> showRequests();
	List<BookIssuseBean> showIssuedBooks();
	List<UserBean> showUsers();
	boolean updatePassword(int id,String password,String newPassword,String role);

}
