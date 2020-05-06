package com.capgemini.librarymanagementsystemhibernate.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemhibernate.dao.UserDAO;
import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;
import com.capgemini.librarymanagementsystemhibernate.dto.BookBorrowBean;
import com.capgemini.librarymanagementsystemhibernate.dto.BookIssuseBean;
import com.capgemini.librarymanagementsystemhibernate.dto.BookRequestBean;
import com.capgemini.librarymanagementsystemhibernate.dto.UserBean;
import com.capgemini.librarymanagementsystemhibernate.factory.LMSFactory;

public class UserServiceImplementation implements UserService{
	private UserDAO dao = LMSFactory.getUserDao();

	@Override
	public boolean register(UserBean user) {
		return dao.register(user);
	}

	@Override
	public UserBean login(String email, String password) {
		return dao.login(email, password);
	}

	@Override
	public boolean addBook(BookBean book) {
		return dao.addBook(book);
	}

	@Override
	public boolean removeBook(int bookId) {

		return dao.removeBook(bookId);
	}

	@Override
	public boolean updateBook(BookBean book) {

		return dao.updateBook(book);
	}

	@Override
	public boolean issueBook(int bookId, int userId) {

		return dao.issueBook(bookId, userId);
	}

	@Override
	public boolean request(int bookId, int userId) {

		return dao.request(bookId,userId);
	}

	@Override
	public List<BookBorrowBean> borrowedBook(int userId) {

		return dao.borrowedBook(userId);
	}

	@Override
	public List<BookBean> searchBookById(int bookId) {

		return dao.searchBookById(bookId);
	}

	@Override
	public List<BookBean> searchBookByTitle(String bookName) {

		return dao.searchBookByTitle(bookName);
	}

	@Override
	public List<BookBean> searchBookByAuthor(String bookAuthor) {
		return dao.searchBookByAuthor(bookAuthor);
	}

	@Override
	public List<BookBean> getBooksInfo() {

		return dao.getBooksInfo();
	}

	@Override
	public List<BookIssuseBean> bookHistoryDetails(int userId) {

		return dao.bookHistoryDetails(userId);
	}

	@Override
	public boolean returnBook(int bookId, int userId, String status) {
		return dao.returnBook(bookId, userId, status);
	}

	@Override
	public List<BookRequestBean> showRequests() {
		return dao.showRequests();
	}

	@Override
	public List<BookIssuseBean> showIssuedBooks() {
		return dao.showIssuedBooks();
	}

	@Override
	public List<UserBean> showUsers() {
		return dao.showUsers();
	}

	@Override
	public boolean updatePassword(String email, String password, String newPassword, String role) {
		return dao.updatePassword(email, password, newPassword, role);
	}

}
