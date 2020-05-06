package com.capgemini.librarymanagementsystem.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagementsystem.dto.AdminBean;
import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.StudentBean;
import com.capgemini.librarymanagementsystem.exception.LMSException;
import com.capgemini.librarymanagementsystem.factory.LibraryFactory;
import com.capgemini.librarymanagementsystem.service.AdminServiceDAO;
import com.capgemini.librarymanagementsystem.service.StudentServiceDAO;
import com.capgemini.librarymanagementsystem.validation.Validation;

public class Library {
	public static void doRegistration() {

		boolean flag = false;

		int id1 = 0; 
		String name1 = null; 
		long mobile1 = 0;
		String email1 = null;
		String password1 = null;

		int id2 = 0; 
		String name2 = null; 
		long mobile2 = 0;
		String email2 = null;
		String password2 = null;

		int bookId = 0; 
		String bookAuthor = null; 
		String bookName = null;
		String bookCategory = null;
		String bookPublisherName = null;
		String bookIssuedate = null;
		String bookReturndate = null;

		Validation validation = new Validation();

		Scanner scanner = new Scanner(System.in);

		do {
			try {
				System.out.println("----------WELCOME TO LIBRARY-----------");
				System.out.println("-----------------------------------");
				System.out.println("Press 1 to Admin Page");
				System.out.println("Press 2 to Student Page");
				System.out.println("-----------------------------------");

				int i = scanner.nextInt();
				switch(i) {
				case 1:
					AdminServiceDAO service = LibraryFactory.getAdminService();
					do{
						try {
							System.out.println("-----------------------------------");
							System.out.println("Press 1 to Admin Register");
							System.out.println("Press 2 to Admin Login");
							System.out.println("Press 3 to Exit");
							System.out.println("-----------------------------------");
							int choice = scanner.nextInt();
							switch (choice) {
							case 1:
								do {
									try {
										System.out.println("Enter ID :");
										id1 = scanner.nextInt();
										validation.validatedId(id1);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										System.err.println("Id should contains only digits");
									} catch (LMSException e) {
										flag = false;
										System.err.println(e.getMessage());
									}
								} while (!flag);

								do {
									try {
										System.out.println("Enter Name :");
										name1 = scanner.next();
										validation.validatedName(name1);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										System.err.println("Name should contains only Alphabates");
									} catch (LMSException e) {
										flag = false;
										System.err.println(e.getMessage());
									}
								} while (!flag);

								do {
									try {
										System.out.println("Enter Mobile :");
										mobile1 = scanner.nextLong();
										validation.validatedMobile(mobile1);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										System.err.println("Mobile Number  should contains only numbers");
									} catch (LMSException e) {
										flag = false;
										System.err.println(e.getMessage());
									}
								} while (!flag);

								do {
									try {
										System.out.println("Enter Email :");
										email1 = scanner.next();
										validation.validatedEmail(email1);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										System.err.println("Email should be proper ");
									} catch (LMSException e) {
										flag = false;
										System.err.println(e.getMessage());
									}
								} while (!flag);

								do {
									try {
										System.out.println("Enter Password :");
										password1 = scanner.next();
										validation.validatedPassword(password1);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										System.err.println("Enter correct Password ");
									} catch (LMSException e) {
										flag = false;
										System.err.println(e.getMessage());
									}
								} while (!flag);

								AdminBean bean = new AdminBean();
								bean.setAdminId(id1);
								bean.setAdminName(name1);
								bean.setPhone(mobile1);
								bean.setEmail(email1);
								bean.setPassword(password1);

								boolean check = service.register(bean);
								if(check) {
									System.out.println("Registered");
								} else {
									System.out.println("Email already exist");
								}	

								break;

							case 2:
								System.out.println("Enter email :");
								String email = scanner.next();
								System.out.println("Enter Password :");
								String password = scanner.next();
								try {
									AdminBean login = service.auth(email, password);
									System.out.println("Logged in");

									do {
										try {
											System.out.println("-----------------------------------");
											System.out.println("Press 1 to Add Books");
											System.out.println("Press 2 to Search the Book by Author");
											System.out.println("Press 3 to Search the Book by Title");
											System.out.println("Press 4 to Search the Book by Category");
											System.out.println("Press 5 to remove the Books");
											System.out.println("Press 6 to Get All The Books Information ");
											System.out.println("Press 7 to Book Issue");
											System.out.println("Press 8 to Show Users");
											System.out.println("Press 9 to Show Requests");
											System.out.println("Press 10 Receive Returned Book");
											System.out.println("Press 11 to Main");
											System.out.println("-----------------------------------");
											int choice1 = scanner.nextInt();
											switch (choice1) {
											case 1:

												do {
													try {
														System.out.println("Enter Book-ID :");
														bookId = scanner.nextInt();
														validation.validatedId(bookId);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println("Id should contains only digits");
													} catch (LMSException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);




												do {
													try {
														System.out.println("Enter Book Name :");
														bookName = scanner.next();
														validation.validatedName(bookName);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println("Book-Name should contains only Alphabets");
													} catch (LMSException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);



												do {
													try {
														System.out.println("Enter Author :");
														bookAuthor = scanner.next();
														validation.validatedName(bookAuthor);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println("Author Name should contains only Alphabates");
													} catch (LMSException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);


												do {
													try {
														System.out.println("Enter Category :");
														bookCategory = scanner.next();
														validation.validatedName(bookCategory);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println("Book-Category should contains only Alphabates");
													} catch (LMSException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);


												do {
													try {
														System.out.println("Enter PublisherName :");
														bookPublisherName = scanner.next();
														validation.validatedName(bookPublisherName);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println("Book-PublisherName should contains only Alphabates");
													} catch (LMSException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);

												BookBean bean1 = new BookBean();
												bean1.setBookId(bookId);	
												bean1.setBookName(bookName);
												bean1.setBookAuthor(bookAuthor);
												bean1.setPublisherName(bookPublisherName);
												bean1.setCategory(bookCategory);
												//bean1.setIssuedate(bookIssuedate);
												boolean check2 = service.addBook(bean1);
												if(check2) {
													System.out.println("Book Added");
												} else {
													System.out.println("Book already exist");
												}
												break;
											case 2:
												System.out.println("Search the book by the Author Name:");
												String author = scanner.next();

												BookBean bean3 = new BookBean();
												bean3.setBookAuthor(author);
												List<BookBean> bookauthor = service.searchBookAuthor(author);
												for (BookBean bookBean : bookauthor) {

													if (bookBean != null) {
														System.out.println("-----------------------------------");
														System.out.println("Book_Id is-->"+bookBean.getBookId());
														System.out.println("Book_Name is-->"+bookBean.getBookName());
														System.out.println("Book_Author is-->"+bookBean.getBookAuthor());
														System.out.println("Book_Category is-->"+bookBean.getCategory());
														System.out.println("Book_PublisherName is-->"+bookBean.getPublisherName());
													} else {
														System.out.println("No books are available written by this author");
													}
												}
												break;
											case 3:
												System.out.println("  Search the book by the Book_Title :");
												String bookTitle = scanner.next();

												BookBean bean4 = new BookBean();
												bean4.setBookName(bookTitle);
												List<BookBean> booktitle = service.searchBookTitle(bookTitle);
												for (BookBean bookBean : booktitle) {	
													if (bookBean != null) {
														System.out.println("-----------------------------------");
														System.out.println("Book_Id is-->"+bookBean.getBookId());
														System.out.println("Book_Name is-->"+bookBean.getBookName());
														System.out.println("Book_Author is-->"+bookBean.getBookAuthor());
														System.out.println("Book_Category is-->"+bookBean.getCategory());
														System.out.println("Book_PublisherName is-->"+bookBean.getPublisherName());
													} else {
														System.out.println("No books are available with this title.");
													}
												}
												break;
											case 4:
												System.out.println("Search the book by the Book_Category :");
												String category = scanner.next();

												BookBean bean5 = new BookBean();
												bean5.setCategory(category);
												List<BookBean> bookIds = service.searchBookType(category);
												for (BookBean bookBean : bookIds) {
													if (bookBean != null) {
														System.out.println("-----------------------------------");
														System.out.println("Book_Id is-->"+bookBean.getBookId());
														System.out.println("Book_Name is-->"+bookBean.getBookName());
														System.out.println("Book_Author is-->"+bookBean.getBookAuthor());
														System.out.println("Book_Category is-->"+bookBean.getCategory());
														System.out.println("Book_PublisherName is-->"+bookBean.getPublisherName());
													} else {
														System.out.println("No books are available with this Id.");
													}
												}
												break;
											case 5:
												System.out.println("Enter the book_Id to delete :");
												int book_Id = scanner.nextInt();
												if (book_Id == 0) {
													System.out.println("Enter the Valid Book_Id");
												} else {
													BookBean bean6 = new BookBean();
													bean6.setBookId(book_Id);
													boolean remove = service.removeBook(book_Id);
													if (remove) {
														System.out.println("The Book is removed");
													} else {
														System.out.println("The Book is not removed");
													}
												}
												break;

											case 6:
												ArrayList<BookBean> info = service.getBooksInfo();
												for (BookBean bookBean : info) {

													if (bookBean != null) {
														System.out.println("-----------------------------------");
														System.out.println("Book_Id is-->"+bookBean.getBookId());
														System.out.println("Book_Name is-->"+bookBean.getBookName());
														System.out.println("Book_Author is-->"+bookBean.getBookAuthor());
														System.out.println("Book_Category is-->"+bookBean.getCategory());
														System.out.println("Book_PublisherName is-->"+bookBean.getPublisherName());
													} else {
														System.out.println("Books info is not present");
													}
												}
												break;
											case 7:
												StudentBean userBean2 = new StudentBean();
												BookBean bookBean2 = new BookBean();
												System.out.println("enter Book Id");
												int bId = scanner.nextInt();
												System.out.println("enter User Id");
												int uId = scanner.nextInt();

												bookBean2.setBookId(bId);
												userBean2.setStudentId(uId);

												try {
													boolean isIssued = service.bookIssue(userBean2, bookBean2);
													if (isIssued) {
														System.out.println("Book Issued");
													} else {
														System.out.println("Book cannot be issued");
													}

												} catch (Exception e) {
													System.out.println("Invalid data request book cannot be issued");
												}
												break;
											case 8:
												try {
													System.out.println("Users of Library are :");
													System.out.println("-------------------------------");

													List<StudentBean> userInfos = service.showUsers();
													for (StudentBean infos : userInfos) {

														System.out.println("User id ---------- " + infos.getStudentId());
														System.out.println("User Name -------- " + infos.getStudentName());
														System.out.println("User Email------ " + infos.getEmail());
														System.out.println("User No Of Books Borrowed ------- " + infos.getBooksBorrowed());

													}
												} catch (Exception e) {
													System.out.println("no books present in library");
												}
												break;
											case 9:
												try {
													System.out.println("Requests for Books are :");
													System.out.println("-------------------------------");

													List<RequestBean> requestInfos = service.showRequests();
													for (RequestBean info1 : requestInfos) {
														System.out.println("........................");
														System.out.println("Book id ---------- " + info1.getBookInfo().getBookId());
														System.out.println("Book Name -------- " + info1.getBookInfo().getBookAuthor());
														System.out.println("User id----------- " + info1.getStudentInfo().getStudentId());
														System.out.println("User Name -------- " + info1.getStudentInfo().getStudentName());
														System.out.println("Book Issued ------" + info1.isIssued());
														System.out.println("Book Returned------" + info1.isReturned());
														System.out.println(".........................");

													}
												} catch (Exception e) {
													System.out.println("no books present in library");
												}
												break;
											case 10:
												System.out.println("Receive Returned Book");
												System.out.println("-----------------------");
												System.out.println("Enter Student Id");
												int user_Id = scanner.nextInt();
												System.out.println("Enter Book Id");
												int book_id = scanner.nextInt();

												StudentBean student = new StudentBean();
												BookBean book = new BookBean();
												student.setStudentId(user_Id);;
												book.setBookId(book_id);
												boolean isReceive = service.isBookReceived(student, book);
												if(isReceive) {
													System.out.println(" Received Returned book");
												}else {
													System.out.println("Invalid ! Admin unable to receive");
												}
												break;
											case 11:
												doReg();
											default:
												System.out.println("Invalid Choice");
												break;
											}
										}catch (InputMismatchException ex) {
											System.out.println("Incorrect entry. Please input only a positive integer.");
											scanner.nextLine();
										}
									} while(true);
								} catch (Exception e) {
									System.out.println("Invalid Credentials");
								}

								break;
							case 3:
								doReg();
								break;
							default:
								System.out.println("Invalid Choice");
								break;
							}
						} catch (InputMismatchException ex) {
							System.out.println("Incorrect entry. Please input only a positive integer.");
							scanner.nextLine();
						}
					} while(true);

				case 2:
					StudentServiceDAO service1 = LibraryFactory.getUserService();

					do {
						try {
							System.out.println("-----------------------------------");
							System.out.println("Press 1 to Student Register");
							System.out.println("Press 2 to Student Login");
							System.out.println("3 to exit");
							System.out.println("-----------------------------------");
							int choice = scanner.nextInt();
							switch (choice) {
							case 1:
								do {
									try {
										System.out.println("Enter ID :");
										id2 = scanner.nextInt();
										validation.validatedId(id2);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										System.err.println("Id should contains only digits");
									} catch (LMSException e) {
										flag = false;
										System.err.println(e.getMessage());
									}
								} while (!flag);

								do {
									try {
										System.out.println("Enter Name :");
										name2 = scanner.next();
										validation.validatedName(name2);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										System.err.println("Name should contains only Alphabates");
									} catch (LMSException e) {
										flag = false;
										System.err.println(e.getMessage());
									}
								} while (!flag);

								do {
									try {
										System.out.println("Enter Mobile :");
										mobile2 = scanner.nextLong();
										validation.validatedMobile(mobile2);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										System.err.println("Mobile Number  should contains only numbers");
									} catch (LMSException e) {
										flag = false;
										System.err.println(e.getMessage());
									}
								} while (!flag);

								do {
									try {
										System.out.println("Enter Email :");
										email2 = scanner.next();
										validation.validatedEmail(email2);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										System.err.println("Email should be proper ");
									} catch (LMSException e) {
										flag = false;
										System.err.println(e.getMessage());
									}
								} while (!flag);

								do {
									try {
										System.out.println("Enter Password :");
										password2 = scanner.next();
										validation.validatedPassword(password2);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										System.err.println("Enter correct Password ");
									} catch (LMSException e) {
										flag = false;
										System.err.println(e.getMessage());
									}
								} while (!flag);

								StudentBean bean1 = new StudentBean();
								bean1.setStudentId(id2);
								bean1.setStudentName(name2);
								bean1.setPhone(mobile2);
								bean1.setEmail(email2);
								bean1.setPassword(password2);

								boolean check = service1.register(bean1);
								if(check) {
									System.out.println("Registered");
								} else {
									System.out.println("Email already exist");
								}
								break;
							case 2:
								System.out.println("Enter email :");
								String email = scanner.next();
								System.out.println("Enter Password :");
								String password = scanner.next();
								try {
									StudentBean login = service1.auth(email, password);
									System.out.println("Logged in");
									do {
										try {
											System.out.println("--------------------------------------------");
											System.out.println("Press 1 to Search the Book by Author");
											System.out.println("Press 2 to Search the Book by Title");
											System.out.println("Press 3 to Search the Book by Category");
											System.out.println("Press 4 to Get the Books Information");
											System.out.println("Press 5 to Request the Book");
											System.out.println("Press 6 to Return the Book");
											System.out.println("Press 7 to main");
											System.out.println("--------------------------------------------");
											int choice2 = scanner.nextInt();
											switch (choice2) {
											case 1:
												System.out.println("Search the book by the Author Name :");
												String author = scanner.next();

												BookBean bean2 = new BookBean();
												bean2.setBookAuthor(author);
												List<BookBean> bookauthor = service1.searchBookAuthor(author);
												for (BookBean bookBean : bookauthor) {

													if (bookBean != null) {
														System.out.println("-----------------------------------");
														System.out.println("Book_Id is-->"+bookBean.getBookId());
														System.out.println("Book_Name is-->"+bookBean.getBookName());
														System.out.println("Book_Author is-->"+bookBean.getBookAuthor());
														System.out.println("Book_Category is-->"+bookBean.getCategory());
														System.out.println("Book_PublisherName is-->"+bookBean.getPublisherName());
														System.out.println("----------------------------------------");
													} else {
														System.out.println("No books are available written by this author");
													}
												}
												break;
											case 2:
												System.out.println("Search the book by the Book_Title :");
												String book_Name = scanner.next();

												BookBean bean3 = new BookBean();
												bean3.setBookName(book_Name);
												List<BookBean> booktitle = service1.searchBookTitle(book_Name);
												for (BookBean bookBean : booktitle) {	
													if (bookBean != null) {
														System.out.println("-----------------------------------");
														System.out.println("Book_Id is-->"+bookBean.getBookId());
														System.out.println("Book_Name is-->"+bookBean.getBookName());
														System.out.println("Book_Author is-->"+bookBean.getBookAuthor());
														System.out.println("Book_Category is-->"+bookBean.getCategory());
														System.out.println("Book_PublisherName is-->"+bookBean.getPublisherName());
														System.out.println("-----------------------------------");
													} else {
														System.out.println("No books are available with this title.");
													}
												}
												break;
											case 3:
												System.out.println(" Search the book by the Book_Category :");
												String book_Category = scanner.next();

												BookBean bean4 = new BookBean();
												bean4.setCategory(book_Category);;
												List<BookBean> bookIds = service1.searchBookType(book_Category);
												for (BookBean bookBean : bookIds) {
													if (bookBean != null) {
														System.out.println("-----------------------------------");
														System.out.println("Book_Id is-->"+bookBean.getBookId());
														System.out.println("Book_Name is-->"+bookBean.getBookName());
														System.out.println("Book_Author is-->"+bookBean.getBookAuthor());
														System.out.println("Book_Category is-->"+bookBean.getCategory());
														System.out.println("Book_PublisherName is-->"+bookBean.getPublisherName());
														System.out.println("...........................................");
													} else {
														System.out.println("No books are available with this Id.");
													}
												}
												break;
											case 4:
												ArrayList<BookBean> info = service1.getBooksInfo();
												for (BookBean bookBean : info) {

													if (bookBean != null) {
														System.out.println("-----------------------------------");
														System.out.println("Book_Id is-->"+bookBean.getBookId());
														System.out.println("Book_Name is-->"+bookBean.getBookName());
														System.out.println("Book_Author is-->"+bookBean.getBookAuthor());
														System.out.println("Book_Category is-->"+bookBean.getCategory());
														System.out.println("Book_PublisherName is-->"+bookBean.getPublisherName());
														System.out.println("..........................................");
													} else {
														System.out.println("Books info is not present");
													}
												}
												break;
											case 5:

												System.out.println("Enter user id");
												int userId = scanner.nextInt();
												StudentBean userBean = new StudentBean();
												userBean.setStudentId(userId);

												System.out.println("Enter book id");
												int bId = scanner.nextInt();
												BookBean bookBean = new BookBean();
												bookBean.setBookId(bId);

												try {
													RequestBean request = service1.bookRequest(userBean, bookBean);
													System.out.println("Request placed to admin");
													System.out.println("-----------------------------------");
													System.out.println("User Id-----" + request.getStudentInfo().getStudentId());
													System.out.println("User name---" + request.getStudentInfo().getStudentName());
													System.out.println("Book Id-----" + request.getBookInfo().getBookId());
													System.out.println("Book Name---" + request.getBookInfo().getBookName());
													System.out.println("............................................");

												} catch (Exception e) {

													System.out.println("Enter valid data or Invalid Request");
												}
												break;
											case 6:

												System.out.println("Returning a book:");
												System.out.println("------------------");
												System.out.println("Enter User Id :");
												int user  = scanner.nextInt();
												System.out.println("Enter Book Id : ");
												int book = scanner.nextInt();
												StudentBean userBean7 = new StudentBean();
												userBean7.setStudentId(user);;
												BookBean bookBean7 = new BookBean();
												bookBean7.setBookId(book);;

												try {
													RequestBean requestInfo = service1.bookReturn(userBean7, bookBean7);
													System.out.println("Book is Returning to Admin");
													System.out.println("-----------------------------------");
													System.out.println("User Id ------"+requestInfo.getStudentInfo().getStudentId());
													System.out.println("Book Id ------"+requestInfo.getBookInfo().getBookId());
													System.out.println("Is Returning --"+requestInfo.isReturned());
													System.out.println(".........................................");

												} catch (Exception e) {
													System.out.println("Invalid Return");
												}

												break;
											case 7:
												doReg();
											default:
												break;
											}
										} catch (InputMismatchException ex) {
											System.out.println("Incorrect entry. Please input only a positive integer.");
											scanner.nextLine();
										}
									} while(true);
								} catch (Exception e) {
									System.out.println("Invalid Credentials");
								}
								break;

							case 3:
								doReg();
							default:
								System.out.println("Invalid Choice");
								break;
							}
						} catch (InputMismatchException ex) {
							System.out.println("Incorrect entry. Please input only a positive integer.");
							scanner.nextLine();
						}
					} while(true);
				}
			}   catch (InputMismatchException ex)   {
				System.out.println("Incorrect entry. Please input only a positive integer.");
				scanner.nextLine();
			}
		}while(true);

	}
}
