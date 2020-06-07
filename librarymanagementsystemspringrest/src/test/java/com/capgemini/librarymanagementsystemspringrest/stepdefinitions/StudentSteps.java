package com.capgemini.librarymanagementsystemspringrest.stepdefinitions;

import org.junit.jupiter.api.Assertions;

import com.capgemini.librarymanagementsystemspringrest.dao.StudentDAO;
import com.capgemini.librarymanagementsystemspringrest.dao.StudentDAOImplement;
import com.capgemini.librarymanagementsystemspringrest.dao.UsersDAO;
import com.capgemini.librarymanagementsystemspringrest.dao.UsersDAOImplement;
import com.capgemini.librarymanagementsystemspringrest.dto.BookBean;
import com.capgemini.librarymanagementsystemspringrest.dto.BookIssueBean;
import com.capgemini.librarymanagementsystemspringrest.dto.RequestDetailsBean;
import com.capgemini.librarymanagementsystemspringrest.dto.UsersBean;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StudentSteps {

	private StudentDAO student = new StudentDAOImplement();
	private UsersDAO dao = new UsersDAOImplement();
	UsersBean info;
	BookBean bookBean;
	private RequestDetailsBean requestBean;
	private BookIssueBean issueBean;
	boolean check;

	@Given("^Student is on login page$")
	public void student_is_on_login_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		info = new UsersBean();
	}

	@When("^Student gives \"([^\"]*)\", \"([^\"]*)\"$")
	public void student_gives(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		info = dao.login(arg1, arg2);
	}

	@Then("^Student is logged in$")
	public void student_is_logged_in() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assertions.assertNotNull(info);
	}

	@Given("^Student is on request page$")
	public void student_is_on_request_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		requestBean = new RequestDetailsBean();
	}

	@When("^BookId and UserId are given (\\d+), (\\d+)$")
	public void bookid_and_UserId_are_given(int arg1, int arg2) throws Throwable {

		check = student.request(arg1, arg2);
	}

	@Then("^Book is Requested successfully$")
	public void book_is_Requested_successfully() throws Throwable {
		Assertions.assertTrue(check);
	}

	@Given("^Student is on return page$")
	public void student_is_on_return_page() throws Throwable {
		issueBean = new BookIssueBean();
	}

	@When("^bookId and userId are given (\\d+), (\\d+)$")
	public void bookid_and_userId_are_given(int arg1, int arg2) throws Throwable {
		check = student.returnBook(arg1, arg2);
	}

	@Then("^Book is returned successfully$")
	public void book_is_returned_successfully() throws Throwable {
		Assertions.assertTrue(check);
	}
}
