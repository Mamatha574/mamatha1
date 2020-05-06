package com.capgemini.librarymanagementsystemjdbc.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.BookBorrowBean;
import com.capgemini.librarymanagementsystemjdbc.dto.BookIssuseBean;
import com.capgemini.librarymanagementsystemjdbc.dto.BookRequestBean;
import com.capgemini.librarymanagementsystemjdbc.dto.UserBean;
import com.capgemini.librarymanagementsystemjdbc.exception.LMSException;
import com.capgemini.librarymanagementsystemjdbc.utility.JdbcUtility;
import com.mysql.jdbc.Statement;

public class UserDAOImplement implements UserDAO{



	@Override
	public boolean register(UserBean user) {


		Connection conn = JdbcUtility.getConnection();
		try(PreparedStatement pstmt = conn.prepareStatement(Query.registerQuery);){

			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, user.getFirstName());
			pstmt.setString(3, user.getLastName());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPassword());
			pstmt.setLong(6, user.getMobile());
			pstmt.setString(7, user.getRole());
			int count = pstmt.executeUpdate();
			if ((user.getEmail().isEmpty()) && (count == 0)) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public UserBean login(String email, String password) {
		try {
			//Properties pro = getProperties();
			Connection conn = JdbcUtility.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(Query.loginQuery);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				UserBean bean = new UserBean();
				bean.setUserId(rs.getInt("userId"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setMobile(rs.getLong("mobile"));
				bean.setRole(rs.getString("role"));
				return bean;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public boolean addBook(BookBean book) {
		try {

			Connection conn = JdbcUtility.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(Query.addBookQuery);
			pstmt.setInt(1, book.getBookId());
			pstmt.setString(2, book.getBookName());
			pstmt.setString(3, book.getBookAuthor());
			pstmt.setString(4, book.getCategory());
			pstmt.setString(5, book.getPublisher());
			// pstmt.setInt(6, book.getCopies());
			int count = pstmt.executeUpdate();
			if (count != 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}



	@Override
	public boolean removeBook(int bookId) {

		try {
			//Properties pro = getProperties();
			Connection conn = JdbcUtility.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(Query.removeBookQuery);
			pstmt.setInt(1, bookId);
			int count = pstmt.executeUpdate();
			if (count != 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}



	@Override
	public boolean updateBook(BookBean book) {
		try {
			//	Properties pro = getProperties();
			Connection conn = JdbcUtility.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(Query.updateBookQuery);
			pstmt.setString(1, book.getBookName());
			pstmt.setInt(2, book.getBookId());
			int count = pstmt.executeUpdate();
			if (count != 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}




	@Override
	public boolean issueBook(int bookId, int userId) {
		try {
			//Properties pro = getProperties();
			Connection conn = JdbcUtility.getConnection();
			PreparedStatement pst = conn.prepareStatement(Query.issueBookQuery1);
			pst.setInt(1, bookId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				try (PreparedStatement pstmt = conn.prepareStatement(Query.issueBookQuery2)) {
					pstmt.setInt(1, userId);
					pstmt.setInt(2, bookId);
					pstmt.setInt(3, userId);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						PreparedStatement pstmt1 = conn.prepareStatement(Query.issueBookQuery3);
						pstmt1.setInt(1, bookId);
						pstmt1.setInt(2, userId);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Calendar cal = Calendar.getInstance();
						String issueDate = sdf.format(cal.getTime());
						pstmt1.setDate(3, java.sql.Date.valueOf(issueDate));
						cal.add(Calendar.DAY_OF_MONTH, 7);
						String returnDate = sdf.format(cal.getTime());
						pstmt1.setDate(4, java.sql.Date.valueOf(returnDate));
						int count = pstmt1.executeUpdate();
						if (count != 0) {
							try (PreparedStatement pstmt2 = conn.prepareStatement(Query.issueBookQuery4)) {
								pstmt2.setInt(1, userId);
								pstmt2.setInt(2, bookId);
								pstmt2.setInt(3, userId);
								int isBorrowed = pstmt2.executeUpdate();
								if (isBorrowed != 0) {
									return true;
								} else {
									return false;
								}
							}
						} else {
							throw new LMSException("Book Not issued");
						}
					} else {
						throw new LMSException("The respective user have not placed any request");
					}
				}
			} else {
				throw new LMSException(" There is no book exist with bookId " + bookId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}




	@Override
	public boolean request(int bookId, int userId) {

		try {
			//Properties pro = getProperties();
			Connection conn = JdbcUtility.getConnection();
			PreparedStatement pst = conn.prepareStatement(Query.requestBookQuery1);
			pst.setInt(1, bookId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				try (PreparedStatement pstmt = conn.prepareStatement(Query.requestBookQuery2);) {
					pstmt.setInt(1, userId);
					pstmt.setInt(2, bookId);
					pstmt.setInt(3, userId);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						int isBookExists = rs.getInt("uid1");
						if (isBookExists == 0) {
							try (PreparedStatement pstmt1 = conn
									.prepareStatement(Query.requestBookQuery3);) {
								pstmt1.setInt(1, userId);
								rs = pstmt1.executeQuery();
								if (rs.next()) {
									int noOfBooksBorrowed = rs.getInt("uid2");
									if (noOfBooksBorrowed < 3) {
										try (PreparedStatement pstmt2 = conn
												.prepareStatement(Query.requestBookQuery4);) {
											pstmt2.setInt(1, userId);
											pstmt2.setInt(2, userId);
											pstmt2.setInt(3, bookId);
											pstmt2.setInt(4, bookId);
											pstmt2.setInt(5, userId);
											int count = pstmt2.executeUpdate();
											if (count != 0) {
												return true;
											} else {
												return false;
											}
										}
									} else {
										throw new LMSException("no Of books limit has crossed");
									}
								} else {
									throw new LMSException("no of books limit has crossed");
								}
							}
						} else {
							throw new LMSException("You have already borrowed the requested book");
						}
					} else {
						throw new LMSException("You have already borrowed the requested book");
					}
				}

			} else {
				throw new LMSException("The book with requested id is not present");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}


	@Override
	public LinkedList<BookBean> searchBookByTitle(String bookName) {

		try {
			//Properties pro = getProperties();
			Connection conn = JdbcUtility.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(Query.searchBookByTitle);
			pstmt.setString(1, bookName);
			ResultSet rs = pstmt.executeQuery();
			LinkedList<BookBean> beans = new LinkedList<BookBean>();
			while (rs.next()) {
				BookBean bean = new BookBean();
				bean.setBookId(rs.getInt("bookId"));
				bean.setBookName(rs.getString("bookName"));
				bean.setBookAuthor(rs.getString("bookAuthor"));
				bean.setCategory(rs.getString("category"));
				bean.setPublisher(rs.getString("publisher"));
				// bean.setCopies(rs.getInt("copies"));
				beans.add(bean);
			}
			return beans;
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<BookBean>();
		}
	}



	@Override
	public LinkedList<BookBean> searchBookByAuthor(String author) {

		try {
			//Properties pro = getProperties();
			Connection conn = JdbcUtility.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(Query.searchBookByAuthor);
			pstmt.setString(1, author);
			ResultSet rs = pstmt.executeQuery();
			LinkedList<BookBean> beans = new LinkedList<BookBean>();
			while (rs.next()) {
				BookBean bean = new BookBean();
				bean.setBookId(rs.getInt("bookId"));
				bean.setBookName(rs.getString("bookName"));
				bean.setBookAuthor(rs.getString("bookAuthor"));
				bean.setCategory(rs.getString("category"));
				bean.setPublisher(rs.getString("publisher"));
				// bean.setCopies(rs.getInt("copies"));
				beans.add(bean);
			}
			return beans;
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<BookBean>();
		}
	}



	@Override
	public LinkedList<BookBean> getBooksInfo() {

		try {
			//Properties pro = getProperties();
			Connection conn = JdbcUtility.getConnection();
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery(Query.getBooksInfoQuery);
			LinkedList<BookBean> beans = new LinkedList<BookBean>();
			while (rs.next()) {
				BookBean bean = new BookBean();
				bean.setBookId(rs.getInt("bookId"));
				bean.setBookName(rs.getString("bookName"));
				bean.setBookAuthor(rs.getString("bookAuthor"));
				bean.setCategory(rs.getString("category"));
				bean.setPublisher(rs.getString("publisher"));
				// bean.setCopies(rs.getInt("copies"));
				beans.add(bean);
			}
			return beans;
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<BookBean>();
		}
	}




	@Override
	public LinkedList<BookIssuseBean> bookHistoryDetails(int userId) {
		try {
			//Properties pro = getProperties();
			Connection conn = JdbcUtility.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(Query.bookHistoryDetailsQuery);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			LinkedList<BookIssuseBean> beans = new LinkedList<BookIssuseBean>();
			while (rs.next()) {
				BookIssuseBean issueDetails = new BookIssuseBean();
				issueDetails.setUserId(rs.getInt("userid"));
				beans.add(issueDetails);
			}
			return beans;
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<BookIssuseBean>();
		}
	}



	@Override
	public List<BookBorrowBean> borrowedBook(int userId) {
		try {
			//Properties pro = getProperties();
			Connection conn = JdbcUtility.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(Query.borrowedBookQuery);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			LinkedList<BookBorrowBean> beans = new LinkedList<BookBorrowBean>();
			while (rs.next()) {
				BookBorrowBean listOfbooksBorrowed = new BookBorrowBean();
				listOfbooksBorrowed.setUserId(rs.getInt("userid"));
				listOfbooksBorrowed.setUserId(rs.getInt("bookid"));
				listOfbooksBorrowed.setEmail(rs.getString("email"));
				beans.add(listOfbooksBorrowed);
			}
			return beans;
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<BookBorrowBean>();
		}
	}



	@Override
	public LinkedList<BookBean> searchBookById(int bookId) {

		try {
			//Properties pro = getProperties();
			Connection conn = JdbcUtility.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(Query.searchBookByIdQuery);
			pstmt.setInt(1, bookId);
			ResultSet rs = pstmt.executeQuery();
			LinkedList<BookBean> beans = new LinkedList<BookBean>();
			while (rs.next()) {
				BookBean bean = new BookBean();
				bean.setBookId(rs.getInt("bookId"));
				bean.setBookName(rs.getString("bookName"));
				bean.setBookAuthor(rs.getString("bookAuthor"));
				bean.setCategory(rs.getString("category"));
				bean.setPublisher(rs.getString("publisher"));
				// bean.setCopies(rs.getInt("copies"));
				beans.add(bean);
			}
			return beans;
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<BookBean>();
		}

	}


	@Override
	public boolean returnBook(int bookId, int userId, String status) {

		try {
			//Properties pro = getProperties();
			Connection conn = JdbcUtility.getConnection();
			PreparedStatement pst = conn.prepareStatement(Query.returnBookQuery1);
			pst.setInt(1, bookId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				try (PreparedStatement pstmt = conn.prepareStatement(Query.returnBookQuery2);) {
					pstmt.setInt(1, bookId);
					pstmt.setInt(2, userId);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						Date issueDate = rs.getDate("issueDate");
						Calendar cal = Calendar.getInstance();
						Date returnDate = cal.getTime();
						long difference = returnDate.getTime()-issueDate.getTime();
						float daysBetween = (difference / (1000 * 60 * 60 * 24));
						if (daysBetween > 7) {
							float fine = daysBetween * 5;
							System.out.println("The user has to pay the fine of the respective book of Rs:" + fine);
							if (status.equals("yes")) {
								try (PreparedStatement pstmt1 = conn
										.prepareStatement(Query.returnBookQuery3);) {
									pstmt1.setInt(1, bookId);
									pstmt1.setInt(2, userId);
									int count = pstmt1.executeUpdate();
									if (count != 0) {
										try (PreparedStatement pstmt2 = conn
												.prepareStatement(Query.returnBookQuery4);) {
											pstmt2.setInt(1, bookId);
											pstmt2.setInt(2, userId);
											int isReturned = pstmt2.executeUpdate();
											if (isReturned != 0) {
												try (PreparedStatement pstmt3 = conn
														.prepareStatement(Query.returnBookQuery5);) {
													pstmt3.setInt(1, bookId);
													pstmt3.setInt(2, userId);
													int isRequestDeleted = pstmt3.executeUpdate();
													if (isRequestDeleted != 0) {
														return true;
													} else {
														return false;
													}
												}
											} else {
												return false;
											}
										}
									} else {
										return false;
									}
								}
							} else {
								throw new LMSException("The User has to pay fine for delaying book return");
							}
						} else {
							if(status.equals("yes")) {
								try (PreparedStatement pstmt1 = conn
										.prepareStatement(Query.returnBookQuery3);) {
									pstmt1.setInt(1, bookId);
									pstmt1.setInt(2, userId);
									int count = pstmt1.executeUpdate();
									if (count != 0) {
										try (PreparedStatement pstmt2 = conn
												.prepareStatement(Query.returnBookQuery4);) {
											pstmt2.setInt(1, bookId);
											pstmt2.setInt(2, userId);
											int isReturned = pstmt2.executeUpdate();
											if (isReturned != 0) {
												try (PreparedStatement pstmt3 = conn
														.prepareStatement(Query.returnBookQuery5);) {
													pstmt3.setInt(1, bookId);
													pstmt3.setInt(2, userId);
													int isRequestDeleted = pstmt3.executeUpdate();
													if (isRequestDeleted != 0) {
														return true;
													} else {
														return false;
													}
												}
											} else {
												return false;
											}
										}
									} else {
										return false;
									}
								}
							}else {
								return false;
							}
						}
					} else {
						throw new LMSException("This respective user hasn't borrowed any book");
					}
				}

			} else {
				throw new LMSException("No book exist with bookId" + bookId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public LinkedList<BookRequestBean> showRequests() {

		try {
			//Properties pro = getProperties();
			Connection conn = JdbcUtility.getConnection();
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery(Query.showRequestsQuery);
			LinkedList<BookRequestBean> beans = new LinkedList<BookRequestBean>();
			while (rs.next()) {
				BookRequestBean bean = new BookRequestBean();
				bean.setUserId(rs.getInt("userId"));
				bean.setFullName(rs.getString("fullName"));
				bean.setBookId(rs.getInt("bookId"));
				bean.setBookName(rs.getString("bookName"));
				beans.add(bean);
			}
			return beans;
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<BookRequestBean>();
		}
	}



	@Override
	public LinkedList<BookIssuseBean> showIssuedBooks() {

		try {
			//Properties pro = getProperties();
			Connection conn = JdbcUtility.getConnection();
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery(Query.showIssuedBooksQuery);
			LinkedList<BookIssuseBean> beans = new LinkedList<BookIssuseBean>();
			while (rs.next()) {
				BookIssuseBean bean = new BookIssuseBean();
				bean.setBookId(rs.getInt("bookId"));
				bean.setUserId(rs.getInt("userId"));
				bean.setIssueDate(rs.getDate("issueDate"));
				bean.setReturnDate(rs.getDate("returnDate"));
				beans.add(bean);
			}
			return beans;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}




	@Override
	public LinkedList<UserBean> showUsers() {

		try {
			//Properties pro = getProperties();
			Connection conn = JdbcUtility.getConnection();
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery(Query.showUsersQuery);
			LinkedList<UserBean> beans = new LinkedList<UserBean>();
			while (rs.next()) {
				UserBean bean = new UserBean();
				bean.setUserId(rs.getInt("userId"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setMobile(rs.getLong("mobile"));
				bean.setRole(rs.getString("role"));
				beans.add(bean);
			}
			return beans;
		} catch (Exception e) {
			e.printStackTrace();
			return new LinkedList<UserBean>();
		}
	}

	@Override
	public boolean updatePassword(String email, String password, String newPassword, String role) {
		try {
			//Properties pro = getProperties();
			Connection conn = JdbcUtility.getConnection();
			PreparedStatement pst = conn.prepareStatement(Query.updatePasswordQuery1);
			pst.setString(1, email);
			pst.setString(2, role);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				try (PreparedStatement pstmt = conn.prepareStatement(Query.updatePasswordQuery2);) {
					pstmt.setString(1, newPassword);
					pstmt.setString(2, email);
					pstmt.setString(3, password);
					int count = pstmt.executeUpdate();
					if (count != 0) {
						return true;
					} else {
						return false;
					}
				}
			} else {
				throw new LMSException("User doesnt exist");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}



