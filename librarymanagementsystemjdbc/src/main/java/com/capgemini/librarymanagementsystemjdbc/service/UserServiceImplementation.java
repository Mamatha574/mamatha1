package com.capgemini.librarymanagementsystemjdbc.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dao.UserDAO;
import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.BookBorrow;
import com.capgemini.librarymanagementsystemjdbc.dto.BookIssuse;
import com.capgemini.librarymanagementsystemjdbc.dto.BookRequest;
import com.capgemini.librarymanagementsystemjdbc.dto.User;
import com.capgemini.librarymanagementsystemjdbc.factory.LMSFactory;

public class UserServiceImplementation implements UserService{
	private UserDAO dao = LMSFactory.getUserDao();

	@Override
	public boolean register(User user) {
		return dao.register(user);
	}

	@Override
	public User login(String email, String password) {
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
	public List<BookBorrow> borrowedBook(int userId) {

		return dao.borrowedBook(userId);
	}

	@Override
	public LinkedList<BookBean> searchBookById(int bookId) {

		return dao.searchBookById(bookId);
	}

	@Override
	public LinkedList<BookBean> searchBookByTitle(String bookName) {

		return dao.searchBookByTitle(bookName);
	}

	@Override
	public LinkedList<BookBean> searchBookByAuthor(String bookAuthor) {
		return dao.searchBookByAuthor(bookAuthor);
	}

	@Override
	public LinkedList<BookBean> getBooksInfo() {

		return dao.getBooksInfo();
	}

	@Override
	public LinkedList<BookIssuse> bookHistoryDetails(int userId) {

		return dao.bookHistoryDetails(userId);
	}

	@Override
	public boolean returnBook(int bookId, int userId, String status) {
		return dao.returnBook(bookId, userId, status);
	}

	@Override
	public LinkedList<BookRequest> showRequests() {
		return dao.showRequests();
	}

	@Override
	public LinkedList<BookIssuse> showIssuedBooks() {
		return dao.showIssuedBooks();
	}

	@Override
	public LinkedList<User> showUsers() {
		return dao.showUsers();
	}

	@Override
	public boolean updatePassword(String email, String password, String newPassword, String role) {
		return dao.updatePassword(email, password, newPassword, role);
	}

}
