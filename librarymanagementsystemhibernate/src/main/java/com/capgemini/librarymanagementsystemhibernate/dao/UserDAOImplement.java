package com.capgemini.librarymanagementsystemhibernate.dao;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;
import com.capgemini.librarymanagementsystemhibernate.dto.BookBorrowBean;
import com.capgemini.librarymanagementsystemhibernate.dto.BookIssuseBean;
import com.capgemini.librarymanagementsystemhibernate.dto.BookRequestBean;
import com.capgemini.librarymanagementsystemhibernate.dto.UserBean;
import com.capgemini.librarymanagementsystemhibernate.exception.LMSException;

public class UserDAOImplement implements UserDAO{
	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;
	int noOfBooks;

	public boolean register(UserBean user) {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(user);
			transaction.commit();
			return true;
		}catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		}finally {
			manager.close();
			factory.close();
		}
	}

	public UserBean login(String email, String password) {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql="select u from UserBean u where u.email=:email and u.password=:password";
			TypedQuery<UserBean> query = manager.createQuery(jpql,UserBean.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			UserBean bean = query.getSingleResult();
			return bean;
		}catch(Exception e){
			System.err.println(e.getMessage());
			return null;
		}finally {
			manager.close();
			factory.close();
		}
	}

	public boolean addBook(BookBean book) {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(book);
			transaction.commit();
			return true;
		}catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		}finally {
			manager.close();
			factory.close();
		}
	}

	public boolean removeBook(int bookId) {
		try(FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBean record = manager.find(BookBean.class,bookId);
			manager.remove(record);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} finally {
			manager.close();
			factory.close();
		}
	}

	public boolean updateBook(BookBean book) {
		try(FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBean record = manager.find(BookBean.class, book.getBookId());
			record.setBookName(book.getBookName());
			transaction.commit();
			return true;
		}catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		}finally {
			manager.close();
			factory.close();
		}
	}

	public boolean issueBook(int bookId, int userId) {
		try(FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "select b from BookBean b where b.bookId=:bookId";
			TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
			query.setParameter("bookId", bookId);
			BookBean rs = query.getSingleResult();
			if(rs != null) {
				String jpql1 = "select r from BookRequestBean r where r.userId=:userId and r.bookId=:bookId";
				TypedQuery<BookRequestBean> query1 = manager.createQuery(jpql1,BookRequestBean.class);
				query1.setParameter("userId", userId);
				query1.setParameter("bookId", bookId);
				List<BookRequestBean> rs1 = query1.getResultList();
				if(!rs1.isEmpty() && rs1 != null) {
					transaction.begin();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
					Calendar cal = Calendar.getInstance();
					String issueDate = sdf.format(cal.getTime());
					cal.add(Calendar.DAY_OF_MONTH, 7);
					String returnDate = sdf.format(cal.getTime());
					BookIssuseBean issueBook = new BookIssuseBean();
					issueBook.setUserId(userId);
					issueBook.setBookId(bookId);
					issueBook.setIssueDate(java.sql.Date.valueOf(issueDate));
					issueBook.setReturnDate(java.sql.Date.valueOf(returnDate));
					manager.persist(issueBook);
					transaction.commit();
					if(!rs1.isEmpty() && rs1 != null) {
						transaction.begin();
						Query bookName = manager.createQuery("select b.bookName from BookBean b where b.bookId=:bookId");
						bookName.setParameter("bookId", bookId);
						List book = bookName.getResultList();
						BookBorrowBean borrowedBooks = new BookBorrowBean();
						borrowedBooks.setBookId(bookId);
						borrowedBooks.setBookName(book.get(0).toString());
						manager.persist(borrowedBooks);
						transaction.commit();
						return true;
					}else {
						throw new LMSException("Book Not issued");
					}
				}else {
					throw new LMSException("The respective user have not placed any request");
				}
			}else {
				throw new LMSException("There is no book exist with bookId"+bookId);
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		}finally {
			manager.close();
			factory.close();
		}
	}

	public boolean request(int bookId, int userId) {
		int count=0;
		try(FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "select b from BookBean b where b.bookId=:bookId";
			TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
			query.setParameter("bookId", bookId);
			List rs = query.getResultList();
			if(rs != null) {
				String jpql1 = "select b from BookBorrowBean b where b.userId=:userId and b.bookId=:bookId";
				TypedQuery<BookBorrowBean> query1 = (TypedQuery<BookBorrowBean>) manager.createQuery(jpql1,BookBorrowBean.class);
				query1.setParameter("userId", userId);
				query1.setParameter("bookId", bookId);
				List rs1 = query1.getResultList();
				if( rs1.isEmpty() || rs1==null ) {
					String jpql2 = "select b from BookIssuseBean b where b.userId=:userId";
					TypedQuery<BookIssuseBean> query2 = (TypedQuery<BookIssuseBean>) manager.createQuery(jpql2,BookIssuseBean.class);
					query2.setParameter("userId", userId);
					List<BookIssuseBean> rs2 = query2.getResultList();
					for(BookIssuseBean p : rs2) {
						noOfBooks = count++;
					}
					if(noOfBooks<3) {
						Query bookName = manager.createQuery("select b.bookName from BookBean b where b.bookId=:bookId");
						bookName.setParameter("bookId", bookId);
						List book = bookName.getResultList();
						Query email = manager.createQuery("select u.email from UserBean u where u.userId=:user_Id");
						email.setParameter("user_Id", userId);
						List userEmail = email.getResultList();
						transaction.begin();
						BookRequestBean request = new BookRequestBean();
						request.setUserId(userId);
						request.setBookId(bookId);
						request.setEmail(userEmail.get(0).toString());
						request.setBookName(book.get(0).toString());
						manager.persist(request);
						transaction.commit();
						return true;

					}else {
						throw new LMSException("You have crossed the book limit");
					}
				}else {
					throw new LMSException("You have already borrowed the requested book");
				}
			}else {
				throw new LMSException("The book with requested id is not present");
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} finally {
			manager.close();
			factory.close();
		}
	}


	public List<BookBorrowBean> borrowedBook(int userId) {
		try(FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookBorrowBean b where b.userId=:userId";
			TypedQuery<BookBorrowBean> query = manager.createQuery(jpql,BookBorrowBean.class);
			query.setParameter("userId", userId);
			List<BookBorrowBean> recordList = query.getResultList();
			return recordList; 
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}finally {
			manager.close();
			factory.close();
		}
	}

	public List<BookBean> searchBookById(int bookId) {
		try(FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookBean b where b.bookId=:bookId";
			TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
			query.setParameter("bookId", bookId);
			List<BookBean> recordList = query.getResultList();
			return recordList; 
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}finally {
			manager.close();
			factory.close();
		}
	}

	public List<BookBean> searchBookByTitle(String bookName) {
		try(FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookBean b where b.bookName=:bookName";
			TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
			query.setParameter("bookName", bookName);
			List<BookBean> recordList = query.getResultList();
			return recordList; 
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}finally {
			manager.close();
			factory.close();
		}
	}

	public List<BookBean> searchBookByAuthor(String bookAuthor) {
		try(FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookBean b where b.bookAuthor=:bookAuthor";
			TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
			query.setParameter("bookAuthor", bookAuthor);
			List<BookBean> recordList = query.getResultList();
			return recordList; 
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}finally {
			manager.close();
			factory.close();
		}
	}

	public List<BookBean> getBooksInfo() {
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = "select b from BookBean b";
		TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
		List<BookBean> recordList = query.getResultList();
		manager.close();
		factory.close();
		return recordList;
	}

	public boolean returnBook(int bookId, int userId, String status) {
		try(FileInputStream info = new FileInputStream("db.properties");){
			Properties pro = new Properties();
			pro.load(info);
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "select b from BookBean b where b.bookId=:bookId";
			TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
			query.setParameter("bookId", bookId);
			BookBean rs = query.getSingleResult();
			if(rs != null) {
				String jpql1 = "select b from BookIssuseBean b where b.bookId=:bookId and b.userId=:userId ";
				TypedQuery<BookIssuseBean> query1 = manager.createQuery(jpql1,BookIssuseBean.class);
				query1.setParameter("bookId", bookId);
				query1.setParameter("userId", userId);
				BookIssuseBean rs1 = query1.getSingleResult();
				if(rs1 != null) {
					Date issueDate = rs1.getIssueDate();
					Calendar cal = Calendar.getInstance();
					Date returnDate = cal.getTime();
					long difference =returnDate.getTime()-issueDate.getTime();
					float daysBetween = (difference / (1000*60*60*24));
					if(daysBetween>7.0) {
						//transaction.begin();
						float fine = daysBetween*5;
						System.out.println("The user has to pay the fine of the respective book of Rs:"+fine);
						if(status=="yes") {
							transaction.begin();

							manager.remove(rs1);
							transaction.commit();
							transaction.begin();
							String jpql3 = "select b from BookBorrowBean b  where b.bookId=:bookId and b.userId=:userId";
							Query query3 = manager.createQuery(jpql3);
							query3.setParameter("bookId", bookId);
							query3.setParameter("userId", userId);
							BookBorrowBean bbb = (BookBorrowBean) query3.getSingleResult();
							//int bbb_Id = bbb.getId();
							manager.remove(bbb);
							transaction.commit();

							transaction.begin();
							String jpql4 = "select r from BookRequestBean r where r.bookId=:bookId and r.userId=:userId";
							Query query4 = manager.createQuery(jpql4);
							query4.setParameter("bId", bookId);
							query4.setParameter("uId", userId);
							BookRequestBean rdb = (BookRequestBean) query4.getSingleResult();
							//int rdb_Id = rdb.getId();
							manager.remove(rdb);
							transaction.commit();
							return true;
						}else {
							throw new LMSException("The User has to pay fine for delaying book return");
						}
					}else {
						transaction.begin();
						/*
						String jpql2 = "select b from BookIssueBean b where b.bId=:bId and b.uId=:uId";
						Query query2 = manager.createQuery(jpql2);
						query2.setParameter("bId", bId);
						query2.setParameter("uId", uId);
						BookIssueBean bib = (BookIssueBean) query2.getSingleResult();
						 */
						//int bib_Id = rs1.getId();
						manager.remove(rs1);
						transaction.commit();

						transaction.begin();
						String jpql3 = "select b from  BookBorrowBean b  where b.bookId=:bookId and b.userId=:userId";
						Query query3 = manager.createQuery(jpql3);
						query3.setParameter("bookId", bookId);
						query3.setParameter("userId", userId);
						BookBorrowBean bbb = (BookBorrowBean) query3.getSingleResult();
						//int bbb_Id = bbb.getId();
						manager.remove(bbb);
						transaction.commit();

						transaction.begin();
						String jpql4 = "select r from RequestDetailsBean r where r.bId=:bId and r.uId=:uId";
						Query query4 = manager.createQuery(jpql4);
						query4.setParameter("bId", bookId);
						query4.setParameter("uId", userId);
						BookRequestBean rdb = (BookRequestBean) query4.getSingleResult();
						//int rdb_Id = rdb.getId();
						manager.remove(rdb);
						transaction.commit();
						return true;
					}

				}else {
					throw new LMSException("This respective user hasn't borrowed any book");
				}
			}else {
				throw new LMSException("book doesnt exist");
			}

		}catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		}finally {
			manager.close();
			factory.close();
		}
	}

	

	public List<BookRequestBean> showRequests() {
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = "select r from BookRequestBean r";
		TypedQuery<BookRequestBean> query = manager.createQuery(jpql,BookRequestBean.class);
		List<BookRequestBean> recordList = query.getResultList();
		manager.close();
		factory.close();
		return recordList;
	}

	public List<BookIssuseBean> showIssuedBooks() {
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = "select b from BookIssuseBean b";
		TypedQuery<BookIssuseBean> query = manager.createQuery(jpql,BookIssuseBean.class);
		List<BookIssuseBean> recordList = query.getResultList();
		manager.close();
		factory.close();
		return recordList;
	}

	public List<UserBean> showUsers() {
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = "select u from UserBean u";
		TypedQuery<UserBean> query = manager.createQuery(jpql,UserBean.class);
		List<UserBean> recordList = query.getResultList();
		manager.close();
		factory.close();
		return recordList;
	}

	public boolean updatePassword(String email, String password, String newPassword, String role) {
		try(FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql = "select u from UserBean u where u.email=:email and u.role=:role and u.password=:password";
			TypedQuery<UserBean> query = manager.createQuery(jpql,UserBean.class);
			query.setParameter("email", email);
			query.setParameter("role", role);
			query.setParameter("password", password);
			UserBean rs = query.getSingleResult();
			if(rs != null) {
				UserBean record = manager.find(UserBean.class,email);
				record.setPassword(newPassword);
				transaction.commit();
				return true;			
			}else {
				throw new LMSException("User doesnt exist");
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public List<BookIssuseBean> bookHistoryDetails(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
}









