package com.capgemini.librarymanagementsystem.service;


import java.util.ArrayList;

import com.capgemini.librarymanagementsystem.dao.StudentDAO;
import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.StudentBean;
import com.capgemini.librarymanagementsystem.factory.LibraryFactory;


public class StudentServiceImplementation implements StudentServiceDAO {

	private StudentDAO dao=LibraryFactory.getUserDao();

	public boolean register(StudentBean std) {
		return dao.register(std);
	}

	public StudentBean auth(String email, String password) {
		return dao.auth(email, password);
	}

	public ArrayList<BookBean> searchBookTitle(String bookName) {
		return dao.searchBookTitle(bookName);
	}

	public ArrayList<BookBean> searchBookAuthor(String bookAuthor) {
		return dao.searchBookAuthor(bookAuthor);
	}

	public ArrayList<BookBean> searchBookType(String bookType) {
		return dao.searchBookType(bookType);
	}

	public ArrayList<Integer> getBookIds() {
		return dao.getBookIds();
	}

	public ArrayList<BookBean> getBooksInfo() {
		return dao.getBooksInfo();
	}

	public RequestBean bookRequest(StudentBean student, BookBean book) {
		
		return dao.bookRequest(student, book);
	}

	public RequestBean bookReturn(StudentBean student, BookBean book) {
		
		return dao.bookReturn(student, book);
	}
}