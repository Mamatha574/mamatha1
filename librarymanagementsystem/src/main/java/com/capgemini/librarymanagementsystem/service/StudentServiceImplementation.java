package com.capgemini.librarymanagementsystem.service;


import java.util.LinkedList;
import java.util.List;

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

	public LinkedList<BookBean> searchBookTitle(String bookName) {
		return dao.searchBookTitle(bookName);
	}

	public LinkedList<BookBean> searchBookAuthor(String bookAuthor) {
		return dao.searchBookAuthor(bookAuthor);
	}

	public LinkedList<BookBean> searchBookType(String bookType) {
		return dao.searchBookType(bookType);
	}

	public LinkedList<Integer> getBookIds() {
		return dao.getBookIds();
	}

	public LinkedList<BookBean> getBooksInfo() {
		return dao.getBooksInfo();
	}

	public RequestBean bookRequest(StudentBean student, BookBean book) {
		
		return dao.bookRequest(student, book);
	}

	public RequestBean bookReturn(StudentBean student, BookBean book) {
		
		return dao.bookReturn(student, book);
	}
}