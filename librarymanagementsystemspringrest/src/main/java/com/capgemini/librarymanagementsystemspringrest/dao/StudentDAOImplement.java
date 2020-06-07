package com.capgemini.librarymanagementsystemspringrest.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystemspringrest.dto.BookBean;
import com.capgemini.librarymanagementsystemspringrest.dto.BookIssueBean;
import com.capgemini.librarymanagementsystemspringrest.dto.BorrowedBooksBean;
import com.capgemini.librarymanagementsystemspringrest.dto.RequestDetailsBean;
import com.capgemini.librarymanagementsystemspringrest.exception.LMSException;

@Repository
public class StudentDAOImplement implements StudentDAO {

	EntityManager manager = null;
	EntityTransaction transaction = null;
	int noOfBooks;

	@PersistenceUnit
	private EntityManagerFactory factory = null;

	@Override
	public List<BorrowedBooksBean> borrowedBook(int uId) {
		try {
			manager = factory.createEntityManager();
			String jpql = "select b from BorrowedBooksBean b where b.uId=:uId";
			TypedQuery<BorrowedBooksBean> query = manager.createQuery(jpql, BorrowedBooksBean.class);
			query.setParameter("uId", uId);
			List<BorrowedBooksBean> recordList = query.getResultList();
			return recordList;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean request(int uId, int bId) {
		int count = 0;
		try {
	manager = factory.createEntityManager();
			String p = "select b from BorrowedBooksBean b where b.uId=:uId and b.bId=:bId ";
			TypedQuery<BorrowedBooksBean> tq = manager.createQuery(p, BorrowedBooksBean.class);
			tq.setParameter("uId", uId);
			tq.setParameter("bId", bId);
			List<BorrowedBooksBean> bb = tq.getResultList();
			if (bb.isEmpty()) {
				String q = "select r from RequestDetailsBean r where r.uId=:uId and r.bId=:bId";
				TypedQuery<RequestDetailsBean> requestQuery = manager.createQuery(q, RequestDetailsBean.class);
				requestQuery.setParameter("uId", uId);
				requestQuery.setParameter("bId", bId);
				List<RequestDetailsBean> record = requestQuery.getResultList();
				if (record.isEmpty()) {
					transaction = manager.getTransaction();
					String jpql = "select b from BookBean b where b.bId=:bId";
					TypedQuery<BookBean> query = manager.createQuery(jpql, BookBean.class);
					query.setParameter("bId", bId);
					List rs = query.getResultList();
					if (!rs.isEmpty()) {
						String jpql1 = "select b from BorrowedBooksBean b where b.uId=:uId and b.bId=:bId";
						TypedQuery<BorrowedBooksBean> query1 = (TypedQuery<BorrowedBooksBean>) manager
								.createQuery(jpql1, BorrowedBooksBean.class);
						query1.setParameter("uId", uId);
						query1.setParameter("bId", bId);
						List rs1 = query1.getResultList();
						if (rs1.isEmpty() || rs1 == null) {
							String jpql2 = "select b from BookIssueBean b where b.uId=:uId";
							TypedQuery<BookIssueBean> query2 = (TypedQuery<BookIssueBean>) manager.createQuery(jpql2,
									BookIssueBean.class);
							query2.setParameter("uId", uId);
							List<BookIssueBean> rs2 = query2.getResultList();
							for (BookIssueBean i : rs2) {
								noOfBooks = count++;
							}
							if (noOfBooks < 5) {
								Query bookName = manager
										.createQuery("select b.bookName from BookBean b where b.bId=:bookId");
								bookName.setParameter("bookId", bId);
								List book = bookName.getResultList();
								Query email = manager
										.createQuery("select u.email from UsersBean u where u.uId=:user_Id");
								email.setParameter("user_Id", uId);
								List userEmail = email.getResultList();
								transaction.begin();
								RequestDetailsBean request = new RequestDetailsBean();
								request.setUId(uId);
								request.setBId(bId);
								request.setEmail(userEmail.get(0).toString());
								request.setBookName(book.get(0).toString());
								manager.persist(request);
								transaction.commit();
								return true;

							} else {
								throw new LMSException("You have crossed the book limit");
							}
						} else {
							throw new LMSException("You have already borrowed the requested book");
						}
					} else {
						throw new LMSException("The book with requested id is not present");
					}

				} else {
					throw new LMSException("You have already requested the book");
				}

			} else {
				throw new LMSException("You have already borrowed the book");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean returnBook(int bId, int uId) {
		try {

			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "select b from BookBean b where b.bId=:bId";
			TypedQuery<BookBean> query = manager.createQuery(jpql, BookBean.class);
			query.setParameter("bId", bId);
			BookBean rs = query.getSingleResult();
			if (rs != null) {
				String jpql1 = "select b from BookIssueBean b where b.bId=:bId and b.uId=:uId ";
				TypedQuery<BookIssueBean> query1 = manager.createQuery(jpql1, BookIssueBean.class);
				query1.setParameter("bId", bId);
				query1.setParameter("uId", uId);
				BookIssueBean rs1 = query1.getSingleResult();
				if (rs1 != null) {
					Date issueDate = rs1.getIssueDate();
					Calendar cal = Calendar.getInstance();
					Date returnDate = cal.getTime();
					long difference = issueDate.getTime() - returnDate.getTime();
					float daysBetween = (difference / (1000 * 60 * 60 * 24));
					if (daysBetween > 7.0) {

						throw new LMSException("The User has to pay fine for delaying book return");
					} else {
						transaction.begin();
						manager.remove(rs1);
						transaction.commit();

						transaction.begin();
						String jpql3 = "select b from BorrowedBooksBean b  where b.bId=:bId and b.uId=:uId";
						Query query3 = manager.createQuery(jpql3);
						query3.setParameter("bId", bId);
						query3.setParameter("uId", uId);
						BorrowedBooksBean bbb = (BorrowedBooksBean) query3.getSingleResult();
						manager.remove(bbb);
						transaction.commit();

						return true;

					}
				} else {
					transaction.begin();
					manager.remove(rs1);
					transaction.commit();

					transaction.begin();
					String jpql3 = "select b from BorrowedBooksBean b  where b.bId=:bId and b.uId=:uId";
					Query query3 = manager.createQuery(jpql3);
					query3.setParameter("bId", bId);
					query3.setParameter("uId", uId);
					BorrowedBooksBean bbb = (BorrowedBooksBean) query3.getSingleResult();
					manager.remove(bbb);
					transaction.commit();

					return true;
				}

			} else {
				throw new LMSException("Book doesnt exist in the library");
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

}
