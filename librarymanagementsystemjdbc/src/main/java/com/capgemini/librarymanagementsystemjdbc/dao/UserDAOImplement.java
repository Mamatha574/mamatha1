package com.capgemini.librarymanagementsystemjdbc.dao;
import java.io.FileInputStream;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.BookBorrow;
import com.capgemini.librarymanagementsystemjdbc.dto.BookIssuse;
import com.capgemini.librarymanagementsystemjdbc.dto.BookRequest;
import com.capgemini.librarymanagementsystemjdbc.dto.User;
import com.capgemini.librarymanagementsystemjdbc.exception.LMSException;
import com.mysql.jdbc.Statement;

public class UserDAOImplement implements UserDAO{

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;
	//int count=0;

	@Override
	public boolean register(User user) {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
					PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("registerQuery"))){
				pstmt.setInt(1,user.getUserId());
				pstmt.setString(2, user.getFirstName());
				pstmt.setString(3, user.getLastName());
				pstmt.setString(4, user.getEmail());
				pstmt.setString(5, user.getPassword());
				pstmt.setLong(6, user.getMobile());
				pstmt.setString(7, user.getRole());
				int count = pstmt.executeUpdate();
				if(user.getEmail().isEmpty() && count==0) {
					return false;
				} else {
					return true;
				}
			}
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	@Override
	public User login(String email, String password) {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
					PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("loginQuery"));) {
				pstmt.setString(1,email);
				pstmt.setString(2,password);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					User bean = new User();
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
			}
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	
	}

	@Override
	public boolean addBook(BookBean book) {
			try(FileInputStream info = new FileInputStream("db.properties");){
				Properties pro = new Properties();
				pro.load(info);
				Class.forName(pro.getProperty("path"));
				try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
						PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("addBookQuery"));) {
					pstmt.setInt(1, book.getBookId());
					pstmt.setString(2, book.getBookName());
					pstmt.setString(3, book.getBookAuthor());
					pstmt.setString(4, book.getCategory());
					pstmt.setString(5, book.getPublisher());
					//pstmt.setInt(6, book.getCopies());
					int count = pstmt.executeUpdate();
					if(count!=0) {
						return true;
					} else {
						return false;
					}
				}
			} catch(Exception e) {
				System.err.println(e.getMessage());
				return false;
			}
		}

	@Override
	public boolean removeBook(int bookId) {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
					PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("removeBookQuery"));) {
				pstmt.setInt(1,bookId);
				int count=pstmt.executeUpdate();
				if(count!=0) {
					return true;
				} else {
					return false;
				}
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	
	}

	@Override
	public boolean updateBook(BookBean book) {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
					PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("updateBookQuery"));) {
				pstmt.setString(1,book.getBookName());
				pstmt.setInt(2,book.getBookId());
				int count=pstmt.executeUpdate();
				if(count!=0) {
					return true;
				} else {
					return false;
				}
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean issueBook(int bookId,int userId) {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
					PreparedStatement pst = conn.prepareStatement(pro.getProperty("issueBookQuery1"));){
				pst.setInt(1, bookId);
				rs = pst.executeQuery();
				if(rs.next()) {
					try(PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("issueBookQuery2"))) {
						pstmt.setInt(1, userId);
						pstmt.setInt(2, bookId);
						pstmt.setInt(3, userId);
						rs = pstmt.executeQuery();
						if(rs.next()) {
							try(PreparedStatement pstmt1 = conn.prepareStatement(pro.getProperty("issueBookQuery3"));){
								pstmt1.setInt(1, bookId);
								pstmt1.setInt(2, userId);
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
								Calendar cal = Calendar.getInstance();
								String issueDate = sdf.format(cal.getTime());
								pstmt1.setDate(3, java.sql.Date.valueOf(issueDate));
								cal.add(Calendar.DAY_OF_MONTH, 7);
								String returnDate = sdf.format(cal.getTime());
								pstmt1.setDate(4, java.sql.Date.valueOf(returnDate));
								int count=pstmt1.executeUpdate();
								if(count != 0) {	
									try(PreparedStatement pstmt2 = conn.prepareStatement(pro.getProperty("issueBookQuery4"))){
										pstmt2.setInt(1, userId);
										pstmt2.setInt(2, bookId);
										pstmt2.setInt(3, userId);
										int isBorrowed = pstmt2.executeUpdate();
										if(isBorrowed != 0) {
											return true;
										}else {
											return false;
										}
									}
								} else {
									throw new LMSException("Book Not issued");
								}					
							}
						} else {
							throw new LMSException("The respective user have not placed any request");
						}			
					}
				}else{
					throw new LMSException(" There is no book exist with bookId "+ bookId);
				}
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean request(int bookId, int userId) {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
					PreparedStatement pst = conn.prepareStatement(pro.getProperty("requestBookQuery1"));) {
				pst.setInt(1,bookId);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					try(PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("requestBookQuery2"));){
						pstmt.setInt(1, userId);
						pstmt.setInt(2, bookId);
						pstmt.setInt(3, userId);
						rs = pstmt.executeQuery();
						if(rs.next()) {
							int isBookExists = rs.getInt("uid1");
							if(isBookExists==0) {
								try(PreparedStatement pstmt1 = conn.prepareStatement(pro.getProperty("requestBookQuery3"));) {
									pstmt1.setInt(1, userId);
									rs=pstmt1.executeQuery();
									if(rs.next()) {
										int noOfBooksBorrowed = rs.getInt("uid2");
										if(noOfBooksBorrowed<3) {
											try(PreparedStatement pstmt2 = conn.prepareStatement(pro.getProperty("requestBookQuery4"));){
												pstmt2.setInt(1,userId);
												pstmt2.setInt(2, userId);
												pstmt2.setInt(3, bookId);
												pstmt2.setInt(4, bookId);
												pstmt2.setInt(5, userId);
												int count = pstmt2.executeUpdate();
												if(count != 0) {
													return true;
												}else {
													return false;
												}
											}				 
										}else {
											throw new LMSException("no Of books limit has crossed");
										}
									}else {
										throw new LMSException("no of books limit has crossed");
									}		
								}				
							}else{
								throw new LMSException("You have already borrowed the requested book");
							}		
						}else {
							throw new LMSException("You have already borrowed the requested book");
						}			
					}

				}else {
					throw new LMSException("The book with requested id is not present");
				}
			}

		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	@Override
	public LinkedList<BookBean> searchBookByTitle(String bookName) {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
					PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("searchBookByTitle"));) {
				pstmt.setString(1,bookName);
				rs=pstmt.executeQuery();
				LinkedList<BookBean> beans = new LinkedList<BookBean>();
				while(rs.next()) {
					BookBean bean = new BookBean();
					bean.setBookId(rs.getInt("bookId"));
					bean.setBookName(rs.getString("bookName"));
					bean.setBookAuthor(rs.getString("bookAuthor"));
					bean.setCategory(rs.getString("category"));
					bean.setPublisher(rs.getString("publisher"));
					//bean.setCopies(rs.getInt("copies"));
					beans.add(bean);
				}
				return beans;
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		} 
	}

	@Override
	public LinkedList<BookBean> searchBookByAuthor(String author) {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
					PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("searchBookByAuthor"));) {
				pstmt.setString(1,author);
				rs=pstmt.executeQuery();
				LinkedList<BookBean> beans = new LinkedList<BookBean>();
				while(rs.next()) {
					BookBean bean = new BookBean();
					bean.setBookId(rs.getInt("bookId"));
					bean.setBookName(rs.getString("bookName"));
					bean.setBookAuthor(rs.getString("bookAuthor"));
					bean.setCategory(rs.getString("category"));
					bean.setPublisher(rs.getString("publisher"));
					//bean.setCopies(rs.getInt("copies"));
					beans.add(bean);
				}
				return beans;
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public LinkedList<BookBean> getBooksInfo() {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
					Statement stmt = (Statement)conn.createStatement();) {
				rs = stmt.executeQuery(pro.getProperty("getBooksInfoQuery"));
				LinkedList<BookBean> beans = new LinkedList<BookBean>();
				while(rs.next()) {
					BookBean bean = new BookBean();
					bean.setBookId(rs.getInt("bookId"));
					bean.setBookName(rs.getString("bookName"));
					bean.setBookAuthor(rs.getString("bookAuthor"));
					bean.setCategory(rs.getString("category"));
					bean.setPublisher(rs.getString("publisher"));
					//bean.setCopies(rs.getInt("copies"));
					beans.add(bean);
				}
				return beans;
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}



	@Override
	public LinkedList<BookIssuse> bookHistoryDetails(int userId) {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
					PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("bookHistoryDetailsQuery"));) {
				pstmt.setInt(1, userId);
				rs=pstmt.executeQuery();
				LinkedList<BookIssuse> beans = new LinkedList<BookIssuse>();
				while(rs.next()) {
					BookIssuse issueDetails = new BookIssuse();
					issueDetails.setUserId(rs.getInt("userid"));
					beans.add(issueDetails);
				} 
				return beans;
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	
	}

	@Override
	public List<BookBorrow> borrowedBook(int userId) {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
					PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("borrowedBookQuery"));) {
				pstmt.setInt(1, userId);
				rs=pstmt.executeQuery();
				LinkedList<BookBorrow> beans = new LinkedList<BookBorrow>();
				while(rs.next()) {
					BookBorrow listOfbooksBorrowed = new BookBorrow();
					listOfbooksBorrowed.setUserId(rs.getInt("userid"));
					listOfbooksBorrowed.setUserId(rs.getInt("bookid"));
					listOfbooksBorrowed.setEmail(rs.getString("email"));
					beans.add(listOfbooksBorrowed);
				} 
				return beans;
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public LinkedList<BookBean> searchBookById(int bookId) {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
					PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("searchBookByIdQuery"));) {
				pstmt.setInt(1,bookId);
				rs=pstmt.executeQuery();
				LinkedList<BookBean> beans = new LinkedList<BookBean>();
				while(rs.next()) {
					BookBean bean = new BookBean();
					bean.setBookId(rs.getInt("bookId"));
					bean.setBookName(rs.getString("bookName"));
					bean.setBookAuthor(rs.getString("bookAuthor"));
					bean.setCategory(rs.getString("category"));
					bean.setPublisher(rs.getString("publisher"));
					//bean.setCopies(rs.getInt("copies"));
					beans.add(bean);
				}
				return beans;
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean returnBook(int bookId, int userId, String status) {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
					PreparedStatement pst = conn.prepareStatement(pro.getProperty("returnBookQuery1"));) {
				pst.setInt(1, bookId);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					try(PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("returnBookQuery2"));){
						pstmt.setInt(1, bookId);
						pstmt.setInt(2, userId);
						rs = pstmt.executeQuery();
						if(rs.next()) {
							Date issueDate = rs.getDate("issueDate");
							Calendar cal = Calendar.getInstance();
							//System.out.println(cal);
							Date returnDate = cal.getTime();
							//System.out.println(returnDate);
							//System.out.println(issueDate.getTime());
							long difference = returnDate.getTime()-issueDate.getTime();
							//System.out.println(difference);
							float daysBetween = (difference / (60*60*24*1000));
							//System.out.println(daysBetween);
							//float daysBetween = ((difference *1.1574074)/ (100000000));
							if(daysBetween>10) {
								float fine = daysBetween*5;
								System.out.println("The user has to pay the fine of the respective book of Rs:"+fine);
								System.out.println(status);
								if(status.equals("yes")) {
									try(PreparedStatement pstmt1 = conn.prepareStatement(pro.getProperty("returnBookQuery3"));) {
										pstmt1.setInt(1,bookId);
										pstmt1.setInt(2,userId);
										int count =  pstmt1.executeUpdate();
										if(count != 0) {
											try(PreparedStatement pstmt2 = conn.prepareStatement(pro.getProperty("returnBookQuery4"));) {
												pstmt2.setInt(1, bookId);
												pstmt2.setInt(2, userId);
												int isReturned = pstmt2.executeUpdate();
												if(isReturned != 0 ) {
													try(PreparedStatement pstmt3 = conn.prepareStatement(pro.getProperty("returnBookQuery5"));){
														pstmt3.setInt(1, bookId);
														pstmt3.setInt(2, userId);
														int isRequestDeleted = pstmt3.executeUpdate();
														if(isRequestDeleted != 0) {
															return true;
														}else {
															return false;
														}
													}
												}else {
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
							}else {
								if(status.equals("yes")) {
								try(PreparedStatement pstmt1 = conn.prepareStatement(pro.getProperty("returnBookQuery3"));) {
									pstmt1.setInt(1,bookId);
									pstmt1.setInt(2,userId);
									int count =  pstmt1.executeUpdate();
									if(count != 0) {
										try(PreparedStatement pstmt2 = conn.prepareStatement(pro.getProperty("returnBookQuery4"));) {
											pstmt2.setInt(1, bookId);
											pstmt2.setInt(2, userId);
											int isReturned = pstmt2.executeUpdate();
											if(isReturned != 0 ) {
												try(PreparedStatement pstmt3 = conn.prepareStatement(pro.getProperty("returnBookQuery5"));){
													pstmt3.setInt(1, bookId);
													pstmt3.setInt(2, userId);
													int isRequestDeleted = pstmt3.executeUpdate();
													if(isRequestDeleted != 0) {
														return true;
													}else {
														return false;
													}
												}
											}else {
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
						}else {
							throw new LMSException("This respective user hasn't borrowed any book");
						}
					}

				}else {
					throw new LMSException("No book exist with bookId"+bookId);
				}

			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public LinkedList<BookRequest> showRequests() {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
					Statement stmt = (Statement)conn.createStatement();
					ResultSet rs = stmt.executeQuery(pro.getProperty("showRequestsQuery"));) {
				LinkedList<BookRequest> beans = new LinkedList<BookRequest>();
				while(rs.next()) {
					BookRequest bean = new BookRequest();
					bean.setUserId(rs.getInt("userId"));
					bean.setFullName(rs.getString("fullName"));
					bean.setBookId(rs.getInt("bookId"));
					bean.setBookName(rs.getString("bookName"));
					beans.add(bean);
				}
				return beans;
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public LinkedList<BookIssuse> showIssuedBooks() {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
					Statement stmt = (Statement)conn.createStatement();
					ResultSet rs = stmt.executeQuery(pro.getProperty("showIssuedBooksQuery"));) {
				LinkedList<BookIssuse> beans = new LinkedList<BookIssuse>();
				while(rs.next()) {
					BookIssuse bean = new BookIssuse();
					bean.setBookId(rs.getInt("bookId"));
					bean.setUserId(rs.getInt("userId"));
					bean.setIssueDate(rs.getDate("issueDate"));
					bean.setReturnDate(rs.getDate("returnDate"));
					beans.add(bean);
				}
				return beans;
			}
		} catch(Exception e) {
			//e.printStackTrace();
			System.err.println(e.getMessage());
			return null;
		}
		
	}

	@Override
	public LinkedList<User> showUsers() {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
					Statement stmt = (Statement)conn.createStatement();
					ResultSet rs = stmt.executeQuery(pro.getProperty("showUsersQuery"));) {
				LinkedList<User> beans = new LinkedList<User>();
				while(rs.next()) {
					User bean = new User();
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
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
			@Override
	public boolean updatePassword(String email, String password, String newPassword, String role) {
				try(FileInputStream info = new FileInputStream("db.properties");){
					Properties pro = new Properties();
					pro.load(info);
					Class.forName(pro.getProperty("path"));
					try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
							PreparedStatement pst = conn.prepareStatement(pro.getProperty("updatePasswordQuery1"))){
						pst.setString(1, email);
						pst.setString(2, role);
						rs=pst.executeQuery();
						if(rs.next()) {
							try(PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("updatePasswordQuery2"));) {
								pstmt.setString(1, newPassword);
								pstmt.setString(2, email);
								pstmt.setString(3,password);
								int count=pstmt.executeUpdate();
								if(count!=0) {
									return true;
								} else {
									return false;
								}
							}
						}else {
							throw new LMSException("User doesnt exist");
						}
					}
				} catch(Exception e) {
					System.err.println(e.getMessage());
					return false;
				}
			}

		}
		