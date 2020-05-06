package com.capgemini.librarymanagementsystem.service;


import java.util.ArrayList;

import java.util.List;

import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.dto.AdminBean;
import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.StudentBean;
import com.capgemini.librarymanagementsystem.factory.LibraryFactory;

public class AdminServiceImplementation  implements AdminServiceDAO {
	private AdminDAO dao =  LibraryFactory.getAdminDao();

	public boolean register(AdminBean adm) {
		return dao.register(adm);
	}

	public AdminBean auth(String email, String password) {
		return dao.auth(email, password);
	}

	public boolean addBook(BookBean book) {

		return dao.addBook(book);
	}

	public ArrayList<BookBean> searchBookTitle(String bookTitle) {

		return dao.searchBookTitle(bookTitle);
	}

	public ArrayList<BookBean> searchBookAuthor(String bookAuthor) {

		return dao.searchBookAuthor(bookAuthor);
	}

	public ArrayList<BookBean> searchBookType(String bookType) {
		return dao.searchBookType(bookType);
	}

	

	public boolean removeBook(int bookId) {

		return dao.removeBook(bookId);
	}

	public ArrayList<Integer> getBookIds() {

		return dao.getBookIds();
	}

	public ArrayList<BookBean> getBooksInfo() {

		return dao.getBooksInfo();
	}

	public List<StudentBean> showUsers() {
		
		return dao.showUsers();
	}

	public List<RequestBean> showRequests() {
		
		return dao.showRequests();
	}

	public boolean bookIssue(StudentBean student, BookBean book) {
	
		return dao.bookIssue(student, book);
	}

	public boolean isBookReceived(StudentBean student, BookBean book) {
		
		return dao.isBookReceived(student, book);
	}

	



}