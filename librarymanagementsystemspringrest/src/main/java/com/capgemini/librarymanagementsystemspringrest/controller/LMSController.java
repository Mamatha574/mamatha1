package com.capgemini.librarymanagementsystemspringrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystemspringrest.dto.BookBean;
import com.capgemini.librarymanagementsystemspringrest.dto.BookBorrowBean;
import com.capgemini.librarymanagementsystemspringrest.dto.BookIssuseBean;
import com.capgemini.librarymanagementsystemspringrest.dto.BookRequestBean;
import com.capgemini.librarymanagementsystemspringrest.dto.ResponseBean;
import com.capgemini.librarymanagementsystemspringrest.dto.UserBean;
import com.capgemini.librarymanagementsystemspringrest.service.UserService;

@RestController
public class LMSController {

	@Autowired
	private UserService service;

	@PostMapping(path = "/addUser", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })

	public ResponseBean addUser(@RequestBody UserBean bean) {
		boolean isAdded = service.register(bean);
		ResponseBean response = new ResponseBean();
		if (isAdded) {
			response.setMessage("record  is inserted");
		} else {
			response.setError(true);
			response.setMessage("unable to add");
		}
		return response;
	}

	@PostMapping(path = "/addBook", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseBean addBook(@RequestBody BookBean bean) {
		boolean isBookAdded = service.addBook(bean);
		ResponseBean response = new ResponseBean();
		if (isBookAdded) {
			response.setMessage("Book added succesfully");
		} else {
			response.setError(true);
			response.setMessage("Book cannot be added");
		}
		return response;

	}

	@PutMapping(path = "/bookUpdate", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseBean updateBook(@RequestBody BookBean bean) {
		boolean isBookUpdated = service.updateBook(bean);
		ResponseBean response = new ResponseBean();
		if (isBookUpdated) {
			response.setMessage("Book updated succesfully");
		} else {
			response.setError(true);
			response.setMessage("Book cannot be updated");
		}
		return response;

	}

	@PostMapping(path = "/login", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseBean authentication(@RequestBody String email, String password) {
		UserBean userLogin = service.login(email, password);
		ResponseBean response = new ResponseBean();
		if (userLogin != null) {
			response.setMessage("Login succesfully");
		} else {
			response.setError(true);
			response.setMessage("Invalid credentials,Please try again");
		}
		return response;
	}

	@DeleteMapping(path = "/removeBook/{bookId} ", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean deleteBook(@PathVariable(name = "bookId") int bookId) {
		boolean isBookDeleted = service.removeBook(bookId);
		ResponseBean response = new ResponseBean();
		if (isBookDeleted) {
			response.setMessage("Book deleted succesfully");
		} else {
			response.setError(true);
			response.setMessage("Book not deleted");
		}
		return response;
	}

	@GetMapping(path = "/BooksInfo", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseBean getBookInfo() {
		List<BookBean> getInfo = service.getBooksInfo();
		ResponseBean response = new ResponseBean();
		if (getInfo != null && !getInfo.isEmpty()) {
			response.setMessage("Books found");
			response.setBookBean1(getInfo);
		} else {
			response.setError(true);
			response.setMessage("They are no books in the Library");
		}
		return response;
	}

	@GetMapping(path = "/BooksByName", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseBean getBookByName(String bookTitle) {
		List<BookBean> bean = service.searchBookByTitle(bookTitle);
		ResponseBean response = new ResponseBean();
		if (bean != null && !bean.isEmpty()) {
			response.setMessage("Books found");
			response.setBookBean1(bean);
		} else {
			response.setError(true);
			response.setMessage("They are no books in the Library");
		}
		return response;
	}

	@GetMapping(path = "/BooksByAuthor", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean getBookByAuthor(String author) {
		List<BookBean> bean = service.searchBookByAuthor(author);
		ResponseBean response = new ResponseBean();
		if (bean != null && !bean.isEmpty()) {
			response.setMessage("Books found");
			response.setBookBean1(bean);
		} else {
			response.setError(true);
			response.setMessage("They are no books in the Library");
		}
		return response;
	}

	@GetMapping(path = "/BooksById", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseBean getBookById(int bookId) {
		List<BookBean> bean = service.searchBookById(bookId);
		ResponseBean response = new ResponseBean();
		if (bean != null && !bean.isEmpty()) {
			response.setMessage("Books found");
			response.setBookBean1(bean);
		} else {
			response.setError(true);
			response.setMessage("They are no books in the Library");
		}
		return response;
	}

	@PostMapping(path = "/bookIssue", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseBean issueBook(@RequestBody int userId, int bookId) {
		boolean isBookIssued = service.issueBook(userId, bookId);
		ResponseBean response = new ResponseBean();
		if (isBookIssued) {
			response.setMessage("Book issued succesfully");
		} else {
			response.setError(true);
			response.setMessage("Book cannot be issued");
		}
		return response;
	}

	@PostMapping(path = "/returnBook", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseBean returnBook(@RequestBody int bookId, int userId, String status) {
		boolean isBookReturned = service.returnBook(bookId, userId, status);
		ResponseBean response = new ResponseBean();
		if (isBookReturned) {
			response.setMessage("Book returned succesfully");
		} else {
			response.setError(true);
			response.setMessage("Book cannot be returned");
		}
		return response;
	}

	@PostMapping(path = "/requestBook", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseBean requestBook(@RequestBody int bookId, int userId) {
		boolean isBookRequested = service.request(bookId, userId);
		ResponseBean response = new ResponseBean();
		if (isBookRequested) {
			response.setMessage("Book requested succesfully");
		} else {
			response.setError(true);
			response.setMessage("Book cannot be requested");
		}
		return response;
	}

	@GetMapping(path = "/showRequests", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean showRequests() {
		List<BookRequestBean> requestDetails = service.showRequests();
		ResponseBean response = new ResponseBean();

		if (requestDetails != null && !requestDetails.isEmpty()) {
			response.setBookRequestBean1(requestDetails);
		} else {
			response.setError(true);
			response.setMessage("They are no requests");
		}
		return response;
	}

	@GetMapping(path = "/showIssuedBooks", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean showIssuedBooks() {
		List<BookIssuseBean> issueList = service.showIssuedBooks();
		ResponseBean response = new ResponseBean();

		if (issueList != null && !issueList.isEmpty()) {
			response.setBookIssuseDetails1(issueList);
		} else {
			response.setError(true);
			response.setMessage("No Books are Issued");
		}
		return response;
	}

	@GetMapping(path = "/showUsers", produces = { MediaType.APPLICATION_JSON_VALUE, 
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean showUsers() {
		List<UserBean> usersList = service.showUsers();
		ResponseBean response = new ResponseBean();

		if (usersList != null && !usersList.isEmpty()) {
			response.setUserBean1(usersList);
		} else {
			response.setError(true);
			response.setMessage("They are no Users");
		}
		return response;
	}

	@PutMapping(path = "/updatePassword", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseBean updatePassord(int id, String password, String newPassword, String role) {
		boolean isUpdated = service.updatePassword(id, password, newPassword, role);
		ResponseBean response = new ResponseBean();

		if (isUpdated) {
			response.setMessage("Password updated successfully");
		} else {
			response.setError(true);
			response.setMessage("Password is not updated");
		}
		return response;
	}

	@GetMapping(path = "/getBorrowedBooks", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean getBorrowedBooks(@RequestBody int id) {
		List<BookBorrowBean> borrowed = service.borrowedBook(id);
		ResponseBean response = new ResponseBean();

		if (borrowed != null && !borrowed.isEmpty()) {
			response.setBookBorrowBean1(borrowed);
		} else {
			response.setError(true);
			response.setMessage("There are no borrowed  books");
		}
		return response;
	}
}
