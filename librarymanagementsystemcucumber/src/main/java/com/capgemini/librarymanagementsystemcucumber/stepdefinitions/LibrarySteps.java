package com.capgemini.librarymanagementsystemcucumber.stepdefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.capgemini.librarymanagementsystemcucumber.testrunner.TestRunner;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LibrarySteps extends TestRunner {

	@Before
	public void openBrowser() throws Exception {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");

		wait = new WebDriverWait(driver, 10);
		action = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Given("^Librarian is on Login page$")
	public void librarian_is_on_Login_page() throws Throwable {

		Thread.sleep(5000);
		String actual = driver.getTitle();
		String excepted = "Library";
		System.out.println(actual);
		driver.findElement(By.linkText("LOGIN")).click();

	}

	@When("^Librarian enters username and password$")
	public void librarian_enters_username_and_password(DataTable arg1) throws Throwable {

		List<List<String>> ele = arg1.raw();
		driver.findElement(By.id("email")).sendKeys(ele.get(0).get(0));
		driver.findElement(By.id("password")).sendKeys(ele.get(0).get(1));
		driver.findElement(By.xpath("//button[text()='login']")).click();
	}

	@Then("^Librarian should be logged in$")
	public void librarian_should_be_logged_in() throws Throwable {
		String actual = driver.getCurrentUrl();
		String excepted = "http://localhost:4200";
		System.out.println(actual);

		// assertTrue("Admin logged in successfully", actual.equals(excepted));

	}

	@Given("^Librarian is on adding book page$")
	public void librarian_is_on_adding_book_page() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'ADMIN')]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[1]/button/a")).click();
	}

	@When("^librarian enters book details$")
	public void librarian_enters_book_details(DataTable arg2) throws Throwable {

		List<List<String>> ele = arg2.raw();
		driver.findElement(By.id("bookName")).sendKeys(ele.get(0).get(0));
		driver.findElement(By.id("author")).sendKeys(ele.get(0).get(1));
		driver.findElement(By.id("category")).sendKeys(ele.get(0).get(3));
		driver.findElement(By.id("publisher")).sendKeys(ele.get(0).get(2));

		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Given("^Librarian is on removing book page$")
	public void librarian_is_on_removing_book_page() throws Throwable {
		driver.findElement(By.linkText("ADMIN")).click();
		driver.findElement(By.xpath("//a[contains(text(),'DeleteBook')]")).click();

	}

	@When("^librarian  clicks on remove book$")
	public void librarian_clicks_on_remove_book() throws Throwable {

	}

	@Then("^Book deleted successfully$")
	public void book_deleted_successfully() throws Throwable {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Given("^Librarian is on issuing book page$")
	public void librarian_is_on_issuing_book_page() throws Throwable {
		driver.findElement(By.xpath("//a[contains(@href, '/admin')]")).click();
		

	}

	@When("^librarian move hover on issuse$")
	public void librarian_move_hover_on_issuse() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Issuse Book')]")).click();
	}

	@Then("^Book issued successfully$")
	public void book_issued_successfully() throws Throwable {
		driver.findElement(By.xpath("//button[contains(.,'Issue')]")).click();

	}

	@Given("^Student is on Login page$")
	public void student_is_on_Login_page() throws Throwable {
		Thread.sleep(5000);
		String actual = driver.getTitle();
		String excepted = "Library";
		System.out.println(actual);
		driver.findElement(By.linkText("LOGIN")).click();
	}

	@When("^Student enters username and password$")
	public void student_enters_username_and_password(DataTable arg1) throws Throwable {
		List<List<String>> ele = arg1.raw();
		driver.findElement(By.id("email")).sendKeys(ele.get(0).get(0));
		driver.findElement(By.id("password")).sendKeys(ele.get(0).get(1));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("^Student should be logged in$")
	public void student_should_be_logged_in() throws Throwable {
		String actual = driver.getCurrentUrl();
		String excepted = "http://localhost:4200";
		System.out.println(actual);
	}

	@Given("^Student is on request book page$")
	public void student_is_on_request_book_page() throws Throwable {
		driver.findElement(By.linkText("STUDENT")).click();
	

	}

	@When("^Student clicks on request button$")
	public void student_clicks_on_request_button() throws Throwable {
		driver.findElement(By.linkText("RequestBook")).click();
	}

	@Then("^Book Requested Successfully$")
	public void book_Requested_Successfully() throws Throwable {
		driver.findElement(By.xpath("//button[contains(.,'RequestBook')]")).click();
	}

	@Given("^Student is on returning book page$")
	public void student_is_on_returning_book_page() throws Throwable {
		driver.findElement(By.linkText("STUDENT")).click();
		driver.findElement(By.linkText("ReturnBook")).click();

	}

	@When("^Student clicks on return button$")
	public void student_clicks_on_return_button() throws Throwable {

	}

	@Then("^Book Returned Successfully$")
	public void book_Returned_Successfully() throws Throwable {
		driver.findElement(By.xpath("//button[contains(.,' Return')]")).click();
	}

	@Given("^Student is on view book page$")
	public void student_is_on_view_book_page() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'STUDENT')]")).click();
	}

	@When("^Student clicks on show books$")
	public void student_clicks_on_show_books() throws Throwable {

	}

	@Then("^Student viewed booked sucessfully$")
	public void student_viewed_booked_sucessfully() throws Throwable {
		driver.findElement(By.linkText("show books")).click();
	}

	@Given("^Librarian is on view book page$")
	public void librarian_is_on_view_book_page() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'ADMIN')]")).click();
	}

	@When("^Librarian clicks on show books$")
	public void librarian_clicks_on_show_books() throws Throwable {

	}

	@Then("^Librarian viewed booked sucessfully$")
	public void librarian_viewed_booked_sucessfully() throws Throwable {
		driver.findElement(By.linkText("Books Info")).click();
	}

	@Given("^User is on Login page$")
	public void user_is_on_Login_page() throws Throwable {
		driver.findElement(By.linkText("REGISTER")).click();
	}

	@When("^Student enters firstName ,lastName,email,password,mobile,role,status$")
	public void student_enters_firstName_lastName_email_password_mobile_role_status(DataTable arg1) throws Throwable {

		List<List<String>> ele = arg1.raw();
		driver.findElement(By.id("firstName")).sendKeys(ele.get(0).get(0));
		driver.findElement(By.id("lastName")).sendKeys(ele.get(0).get(1));
		driver.findElement(By.id("email")).sendKeys(ele.get(0).get(2));
		driver.findElement(By.id("password")).sendKeys(ele.get(0).get(3));
		driver.findElement(By.id("mobile")).sendKeys(ele.get(0).get(4));
		driver.findElement(By.id("role")).sendKeys(ele.get(0).get(5));

	}

	@Then("^User should be logged in$")
	public void user_should_be_logged_in() throws Throwable {

		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Then("^close browser page$")
	public void close_browser_page() throws Throwable {
		Thread.sleep(2000);
		driver.close();
	}

	@Then("^librarian logout page$")
	public void librarian_logout_page() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
	}

	@Then("^student logout page$")
	public void student_logout_page() throws Throwable {
		Thread.sleep(2000);
		driver.close();

	}

}
