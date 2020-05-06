package com.capgemini.librarymanagementsystem.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagementsystem.db.DataBase;
import com.capgemini.librarymanagementsystem.dto.AdminBean;
import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.StudentBean;

import com.capgemini.librarymanagementsystem.exception.LMSException;
import com.capgemini.librarymanagementsystem.factory.LibraryFactory;
import com.capgemini.librarymanagementsystem.service.AdminServiceDAO;
import com.capgemini.librarymanagementsystem.service.StudentServiceDAO;
import com.capgemini.librarymanagementsystem.validation.Validation;

public class LibraryController {
	public static void main(String[] args) {
		doReg();
	}
	public static Scanner scanner = new Scanner(System.in);
	private static final Validation validation = new Validation();
	public	static final AdminServiceDAO service = LibraryFactory.getAdminService();
	public static final	StudentServiceDAO service1 = LibraryFactory.getUserService();

	public static int checkChoice() {
		boolean flag = false;
		int choice = 0;
		do {
			try {
				choice = scanner.nextInt();
				flag = true;
			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Invalid Choice, It should contails only digits");
				scanner.next();
			} catch (LMSException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);
		return choice;
	}

	public static int checkId() {
		boolean flag = false;
		int id = 0;
		do {
			try {
				id = scanner.nextInt();
				validation.validatedId(id);
				flag = true;
			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Invalid Id,It should contails only digits");
				scanner.next();
			} catch (LMSException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);

		return id;
	}

	public static String checkName() {
		String name = null;
		boolean flag = false;
		do {
			try {
				name = scanner.nextLine();
				validation.validatedName(name);
				flag = true;
			} catch (LMSException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);
		// return userName.toLowerCase();
		return name;

	}

	public static String checkEmailId() {
		String emailId = null;
		boolean flag = false;
		do {
			try {
				emailId = scanner.next();
				validation.validatedEmail(emailId);
				flag = true;
			} catch (LMSException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);
		emailId.toLowerCase();
		return emailId;
	}

	public static String checkPassword() {
		String password = null;
		boolean flag = false;
		do {
			try {
				password = scanner.next();
				validation.validatedPassword(password);
				flag = true;
			} catch (LMSException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);

		return password;
	}

	private static Long checkPhone() {
		boolean flag = false;
		Long phone =0L;
		do {
			try {
				phone = scanner.nextLong();
				flag = true;
			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Phonenumber should contains only digits ");
				scanner.next();
			}
		} while (!flag);
		return phone;
	}

	private static boolean checkAvailability() {
		boolean isAvail = false;
		boolean flag = false;
		do {
			try {
				isAvail = scanner.nextBoolean();
				flag = true;
			} catch (InputMismatchException e) {
				System.err.println("Enter Boolean value true/false");
				flag = false;
				scanner.next();
			}
		} while (!flag);
		return isAvail;
	}


	public static void doReg() {

		DataBase.addToDatabase();

		AdminBean adminBean = null;
		//BookBean bookBean = null;

		boolean flag = false;
		int choice = 0;
		int i = 0;
		int userChoice = 0;
		int userId = 0;
		int bookId = 0;
		Long mobile=  0L;
		String emailId = null;
		String password = null;
		String newPassword = null;
		String name = null;
		String bookName= null;
		String bookAuthor=null;
		String bookPublisherName= null;
		String bookTitle = null;
		String bookCategory=null;
		boolean isAvail = false;


		//		int id1 = 0; 
		//		String name1 = null; 
		//		long mobile1 = 0;
		//		String email1 = null;
		//		String password1 = null;
		//
		//		int id2 = 0; 
		//		String name2 = null; 
		//		long mobile2 = 0;
		//		String email2 = null;
		//		String password2 = null;
		//
		//		int bookId = 0; 
		//		String bookAuthor = null; 
		//		String bookName = null;
		//		String bookCategory = null;
		//		String bookPublisherName = null;
		//		//String bookIssuedate = null;
		//		//String bookReturndate = null;


		do {
			
				System.out.println("----------WELCOME TO LIBRARY-----------");
				System.out.println("-----------------------------------");
				System.out.println("Press 1 to Admin Page");
				System.out.println("Press 2 to Student Page");
				System.out.println("-----------------------------------");

				i= checkChoice();

				switch(i) {
				case 1:

					do{
						try {
							System.out.println("-----------------------------------");
							System.out.println("Press 1 to Admin Register");
							System.out.println("Press 2 to Admin Login");
							System.out.println("Press 3 to Exit");
							System.out.println("-----------------------------------");
							i = checkChoice();
							switch (i) {
							case 1:
								System.out.println("Enter Admin Registration Details");
								System.out.println("---------------------------------");
								//								System.out.println("Enter User id :");
								//								userId = checkId();
								//								userId = rand.nextInt(1000); 
								userId = (int) (Math.random()*1000);
								if(userId <= 100) {
									userId =userId + 100;
								}

								System.out.println("User Id : "+ userId);
								scanner.nextLine();
								System.out.println("Enter User name");
								name = checkName();
								System.out.println("Enter mobile number");
								mobile= checkPhone();
								System.out.println("Enter User Email Id");
								emailId = checkEmailId();
								System.out.println("Enter User password");
								password = checkPassword();


								AdminBean bean = new AdminBean();
								bean.setAdminId(userId);
								bean.setAdminName(name);
								bean.setPhone(mobile);
								bean.setEmail(emailId);
								bean.setPassword(password);

								boolean check = service.register(bean);
								if(check) {
									System.out.println("Registered");
								} else {
									System.out.println("Email already exist");
								}	

								break;

							case 2:
								System.out.println("Enter email :");
								emailId = checkEmailId();
								System.out.println("Enter Password :");
								password = checkPassword();
								try {
									AdminBean login = service.auth(emailId, password);
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
											i = checkChoice();
											switch (i) {
											case 1:

												System.out.println("Add Book Details: ");
												System.out.println("---------------------------");
												//												System.out.println("Enter book Id: ");
												//												bookId = checkId();
												//												bookId = rand.nextInt(1000);
												bookId = (int) (Math.random()*1000);
												if(bookId <= 100) {
													bookId =bookId + 100;
												}
												System.out.println("Book Id : "+bookId);

												System.out.println("Enter book Book Title: ");
												scanner.nextLine();
												bookTitle = checkName();
												System.out.println("Enter Book Name: ");
												bookName = checkName();
												System.out.println("Enter Book Author : ");
												bookAuthor = checkName();
												System.out.println("Enter Publisher Name: ");
												bookPublisherName = checkName();
												System.out.println("Enter Book Category: ");
												bookCategory=checkName();

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
												bookAuthor = scanner.nextLine();
												bookAuthor=checkName();

												BookBean bean3 = new BookBean();
												bean3.setBookAuthor(bookAuthor);
												List<BookBean> bookauthor = service.searchBookAuthor(bookAuthor);
												for (BookBean bookBean : bookauthor) {

													if (bookBean != null) {
														System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s","BOOKID" ,"BOOKNAME","BOOKAUTHOR","BOOKCATEGORY","PUBLISHERNAME"));
														System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s",bookBean.getBookId(),
																bookBean.getBookName(),bookBean.getBookAuthor(),bookBean.getCategory(),bookBean.getPublisherName()));
														
													} else {
														System.out.println("No books are available written by this author");
													}
												}
												break;
												
											case 3:
												System.out.println("  Search the book by the BookTitle :");
												bookTitle=checkName();

												BookBean bean4 = new BookBean();
												bean4.setBookName(bookTitle);
												List<BookBean> booktitle = service.searchBookTitle(bookTitle);
												for (BookBean bookBean : booktitle) {	
													if (bookBean != null) {
														System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s","BOOKID" ,
																"BOOKNAME","BOOKAUTHOR","BOOKCATEGORY","PUBLISHERNAME"));
														System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s",bookBean.getBookId(),bookBean.getBookName(),bookBean.getBookAuthor(),
																bookBean.getCategory(),bookBean.getPublisherName()));
													} else {
														System.out.println("No books are available with this title.");
													}
												}
												break;
												
											case 4:
												System.out.println("Search the book by the Book_Category :");
												bookCategory = checkName();


												BookBean bean5 = new BookBean();
												bean5.setCategory(bookCategory);
												List<BookBean> bookIds = service.searchBookType(bookCategory);
												for (BookBean bookBean : bookIds) {
													if (bookBean != null) {
														System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s","BOOKID" ,
																"BOOKNAME","BOOKAUTHOR","BOOKCATEGORY","PUBLISHERNAME"));
														System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s",bookBean.getBookId(),bookBean.getBookName(),bookBean.getBookAuthor(),
																bookBean.getCategory(),bookBean.getPublisherName()));
														
													} else {
														System.out.println("No books are available with this Id.");
													}
												}
												break;
												
											case 5:
												System.out.println("Enter the book_Id to delete :");
												bookId = checkId();
												if (bookId == 0) {
													System.out.println("Enter the Valid Book_Id");
												} else {
													BookBean bean6 = new BookBean();
													bean6.setBookId(bookId);
													boolean remove = service.removeBook(bookId);
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
														System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s","BOOKID" ,
																"BOOKNAME","BOOKAUTHOR","BOOKCATEGORY","PUBLISHERNAME"));
														System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s",
																bookBean.getBookId(),bookBean.getBookName(),bookBean.getBookAuthor()
																,bookBean.getCategory(),bookBean.getPublisherName()));
														
													} else {
														System.out.println("Books info is not present");
													}
												}
												break;
											case 7:
												StudentBean userBean2 = new StudentBean();
												BookBean bookBean2 = new BookBean();
												System.out.println("enter Book Id");
												bookId = checkId();
												System.out.println("enter User Id");
												userId = checkId();

												bookBean2.setBookId(bookId);
												userBean2.setStudentId(userId);

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
														System.out.println(String.format("%-10s %-20s %-30s %-25s", "USER ID", "NAME",
																"EMAIL ID", "NO OF BOOKS BORROWED"));
														System.out.println(String.format("%-10s %-20s %-30s %-25s %-5s",
																infos.getStudentId(),infos.getStudentName(),infos.getEmail(),infos.getBooksBorrowed()));
														
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

														System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s","BOOKID" ,
																"BOOKNAME","BOOKAUTHOR","BOOKCATEGORY","PUBLISHERNAME"));
														System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s",
																info1.getBookInfo().getBookId(),info1.getBookInfo().getBookAuthor(),info1.getStudentInfo().getStudentId(),
																info1.getStudentInfo().getStudentName(),info1.isIssued(),info1.isReturned()));

																								System.out.println(".........................");

													}
												} catch (LMSException e) {
													System.err.println(e.getMessage());
												}
												break;
											case 10:
												System.out.println("Receive Returned Book");
												System.out.println("-----------------------");
												System.out.println("Enter Student Id");
												userId= checkId();
												System.out.println("Enter Book Id");
												bookId = scanner.nextInt();

												StudentBean student = new StudentBean();
												BookBean book = new BookBean();
												student.setStudentId(userId);;
												book.setBookId(bookId);
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


					do {
						try {
							System.out.println("-----------------------------------");
							System.out.println("Press 1 to Student Register");
							System.out.println("Press 2 to Student Login");
							System.out.println("3 to exit");
							System.out.println("-----------------------------------");
							choice = checkChoice();
							switch (choice) {
							case 1:

								System.out.println("Enter Stude Registration Details");
								System.out.println("---------------------------------");
								//							System.out.println("Enter User id :");
								//							userId = checkId();
								//							userId = rand.nextInt(1000); 
								userId = (int) (Math.random()*1000);
								if(userId <= 100) {
									userId =userId + 100;
								}
								System.out.println("User Id : "+ userId);
								scanner.nextLine();
								System.out.println("Enter User name");
								name = checkName();
								System.out.println("Enter mobile number");
								mobile=checkPhone();
								System.out.println("Enter User Email Id");
								emailId = checkEmailId();
								System.out.println("Enter User password");
								password = checkPassword();

								StudentBean bean1 = new StudentBean();
								bean1.setStudentId(userId);
								bean1.setStudentName(name);
								bean1.setPhone(mobile);
								bean1.setEmail(emailId);
								bean1.setPassword(password);

								boolean check = service1.register(bean1);
								if(check) {
									System.out.println("Book Added");
								} else {
									System.out.println("Book already exist");
								}
								break;

							case 2:
								System.out.println("Enter email :");
								emailId = checkEmailId();
								System.out.println("Enter Password :");
								password = checkPassword();
								try {
									StudentBean login = service1.auth(emailId, password);
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
												 
														System.out.println("Search the book by the Author Name:");
														bookAuthor = checkName();

														BookBean bean3 = new BookBean();
														bean3.setBookAuthor(bookAuthor);
														List<BookBean> bookauthor = service1.searchBookAuthor(bookAuthor);
														for (BookBean bookBean : bookauthor) {

															if (bookBean != null) {
																System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s","BOOKID" ,"BOOKNAME","BOOKAUTHOR","BOOKCATEGORY","PUBLISHERNAME"));
																System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s",bookBean.getBookId(),
																		bookBean.getBookName(),bookBean.getBookAuthor(),bookBean.getCategory(),bookBean.getPublisherName()));
																
															} else {
																System.out.println("No books are available written by this author");
															}
														}
														break;
														

												

											case 2:
												System.out.println("  Search the book by the BookTitle :");
												bookTitle=checkName();

												BookBean bean4 = new BookBean();
												bean4.setBookName(bookTitle);
												List<BookBean> booktitle = service1.searchBookTitle(bookTitle);
												for (BookBean bookBean : booktitle) {	
													if (bookBean != null) {
														System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s","BOOKID" ,
																"BOOKNAME","BOOKAUTHOR","BOOKCATEGORY","PUBLISHERNAME"));
														System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s",bookBean.getBookId(),bookBean.getBookName(),bookBean.getBookAuthor(),
																bookBean.getCategory(),bookBean.getPublisherName()));
													} else {
														System.out.println("No books are available with this title.");
													}
												}
												break;
												

											case 3:
												System.out.println("Search the book by the Book_Category :");
												bookCategory = checkName();


												BookBean bean5 = new BookBean();
												bean5.setCategory(bookCategory);
												List<BookBean> bookIds = service1.searchBookType(bookCategory);
												for (BookBean bookBean : bookIds) {
													if (bookBean != null) {
														System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s","BOOKID" ,
																"BOOKNAME","BOOKAUTHOR","BOOKCATEGORY","PUBLISHERNAME"));
														System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s",bookBean.getBookId(),bookBean.getBookName(),bookBean.getBookAuthor(),
																bookBean.getCategory(),bookBean.getPublisherName()));
														
													} else {
														System.out.println("No books are available with this Id.");
													}
												}
												break;

												

											case 4:
												ArrayList<BookBean> info = service1.getBooksInfo();
												for (BookBean bookBean : info) {

													if (bookBean != null) {
														System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s","BOOKID" ,
																"BOOKNAME","BOOKAUTHOR","BOOKCATEGORY","PUBLISHERNAME"));
														System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s",
																bookBean.getBookId(),bookBean.getBookName(),bookBean.getBookAuthor(),bookBean.getCategory(),bookBean.getPublisherName()));
														//														
														//														System.out.println("-----------------------------------");
														//														System.out.println("Book_Id is-->"+bookBean.getBookId());
														//														System.out.println("Book_Name is-->"+bookBean.getBookName());
														//														System.out.println("Book_Author is-->"+bookBean.getBookAuthor());
														//														System.out.println("Book_Category is-->"+bookBean.getCategory());
														//														System.out.println("Book_PublisherName is-->"+bookBean.getPublisherName());
													} else {
														System.out.println("Books info is not present");
													}
												}

												break;

											case 5:

												System.out.println("Enter user id");
												userId = checkId();
												StudentBean userBean = new StudentBean();
												userBean.setStudentId(userId);

												System.out.println("Enter book id");
												bookId = checkId();
												BookBean bookBean = new BookBean();
												bookBean.setBookId(bookId);

												try {
													RequestBean request = service1.bookRequest(userBean, bookBean);


													System.out.println(String.format("%-10s %-10s %-10s %-10s ","USERID" ,
															"USERNAME","BOOKID","BOOKNAME"));
													System.out.println(String.format("%-10s %-10s %-10s %-10s ",
															request.getStudentInfo().getStudentId(),request.getStudentInfo().getStudentName(),request.getStudentInfo().getStudentName(),
															request.getBookInfo().getBookName()));


													//													System.out.println("Request placed to admin");
													//													System.out.println("-----------------------------------");
													//													System.out.println("User Id-----" + request.getStudentInfo().getStudentId());
													//													System.out.println("User name---" +request.getStudentInfo().getStudentId());
													//													System.out.println("Book Id-----" + request.getStudentInfo().getStudentId());
													//													System.out.println("Book Name---" + request.getStudentInfo().getStudentId());
													//													System.out.println("............................................");

												} catch (Exception e) {

													System.out.println("Enter valid data or Invalid Request");
												}
												break;
											case 6:

												System.out.println("Returning a book:");
												System.out.println("------------------");
												System.out.println("Enter User Id :");
												userId  = checkId();
												System.out.println("Enter Book Id : ");
												bookId = checkId();
												StudentBean userBean7 = new StudentBean();
												userBean7.setStudentId(userId);;
												BookBean bookBean7 = new BookBean();
												bookBean7.setBookId(bookId);;

												try {
													RequestBean requestInfo = service1.bookReturn(userBean7, bookBean7);
													System.out.println(String.format("%-10s %-10s %-10s %-10s ","USERID" ,
															"BOOKID","ISRETURNED"));
													System.out.println(String.format("%-10s %-10s %-10s",requestInfo.getStudentInfo().getStudentId(),requestInfo.getBookInfo().getBookId(),
															requestInfo.isReturned()));

													//													System.out.println("Book is Returning to Admin");
													//													System.out.println("-----------------------------------");
													//													System.out.println("User Id ------"+requestInfo.getStudentInfo().getStudentId());
													//													System.out.println("Book Id ------"+requestInfo.getBookInfo().getBookId());
													//													System.out.println("Is Returning --"+requestInfo.isReturned());
													//													System.out.println(".........................................");

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
								System.out.println("Invalid Choice(only 1,2,3)");
								break;
							}
						} catch (InputMismatchException ex) {
							System.out.println("Incorrect entry. Please input only a positive integer.");
							scanner.nextLine();
						}
					} while(true);
				
		default:
			System.err.println("Invalid Choice, Choice Must be in beween 1 and 2");
			break;
				}	
		}while(true);
		
	}

}