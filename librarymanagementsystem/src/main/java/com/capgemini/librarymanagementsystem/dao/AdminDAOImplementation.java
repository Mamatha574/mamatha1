package com.capgemini.librarymanagementsystem.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.db.DataBase;
import com.capgemini.librarymanagementsystem.dto.AdminBean;
import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.StudentBean;
import com.capgemini.librarymanagementsystem.exception.LMSException;


public class AdminDAOImplementation implements AdminDAO {
	Date date = new Date();
	Date expectedReturnDate = new Date();
	Date retunedDate = new Date();
	Calendar calendar = Calendar.getInstance();

	public boolean register(AdminBean adm) {

		for (AdminBean adminbean : DataBase.admin) {
			if (adminbean.getEmail().equals(adm.getEmail())) {
				return false;
			}

		}
		DataBase.admin.add(adm);
		return true;
	}

	public AdminBean auth(String regEmail, String regPassword) {
		for (AdminBean bean : DataBase.admin) {
			if (bean.getEmail().equals(regEmail) && bean.getPassword().equals(regPassword)) {
				System.out.println("Login success");
				return bean;
			} 
			throw new LMSException ("Invalid email and password");

		}
		return null;
	}


	public boolean delete(BookBean book) {
		for (BookBean bean : DataBase.book) {
			if (bean.getBookId()==book.getBookId()) {
				return false;
			}

		}
		DataBase.book.add(book);
		return true;
	}


	public boolean addBook(BookBean book) {
		for (BookBean bean : DataBase.book) {
			if (bean.getBookId()==book.getBookId()) {
				return false;
			}
		}
		DataBase.book.add(book);
		return true;
	}

	public LinkedList<BookBean> searchBookTitle(String bookName) {
		LinkedList<BookBean> searchList=new LinkedList<BookBean>();
		for(int i=0;i<=DataBase.book.size()-1;i++)
		{
			BookBean retrievedBook=DataBase.book.get(i);
			String retrievedBname=retrievedBook.getBookName();
			if(bookName.equals(retrievedBname))
			{
				searchList.add(retrievedBook);	
				return searchList;
			}
		}
		if(searchList.size()==0)
		{
			throw new LMSException("Book not found");
		}
		else
		{
			return searchList;
		}

	}

	public LinkedList<BookBean> searchBookAuthor(String bookAuthor) {

		LinkedList<BookBean> searchList=new LinkedList<BookBean>();
		for(int i=0;i<=DataBase.book.size()-1;i++)
		{
			BookBean retrievedBook=DataBase.book.get(i);
			String retrievedBAuthor=retrievedBook.getBookAuthor();
			if(bookAuthor.equals(retrievedBAuthor))
			{
				searchList.add(retrievedBook);	
			}
		}
		if(searchList.size()==0)
		{
			throw new LMSException("Book not found");
		}
		else
		{
			return searchList;
		}		

	}

	public LinkedList<BookBean> searchBookType(String bookType) {
		LinkedList<BookBean> searchList=new LinkedList<BookBean>();
		for(int i=0;i<=DataBase.book.size()-1;i++)
		{
			BookBean retrievedBook=DataBase.book.get(i);
			String retrievedBookType=retrievedBook.getCategory();
			if(bookType.equals(retrievedBookType))
			{
				searchList.add(retrievedBook);	
			}
		}
		if(searchList.size()==0)
		{
			throw new LMSException("Book not found");
		}
		else
		{
			return searchList;
		}		
	}

	public boolean updateBook(int bookId) {
		for(int i=0;i<=DataBase.book.size()-1;i++)
		{
			BookBean retrievedBook=DataBase.book.get(i);
			int retrievedId=retrievedBook.getBookId();
			if(bookId==retrievedId)
			{
				break;
			}
		}
		throw new LMSException("Book not updated");
	}


	public boolean removeBook(int bookId) {
		boolean status=false;
		for(int i=0;i<=DataBase.book.size()-1;i++)
		{
			BookBean retrievedBook=DataBase.book.get(i);
			int retrievedId=retrievedBook.getBookId();
			if(bookId==retrievedId)
			{
				status=true;
				DataBase.book.remove(i);
				break;
			}
		}
		return status;

	}

	public LinkedList<Integer> getBookIds() {
		LinkedList<Integer> idList=new LinkedList<Integer>();
		for(int i=0;i<=DataBase.book.size()-1;i++)
		{
			BookBean retrievedBook=DataBase.book.get(i);
			int retrievedBookId=retrievedBook.getBookId();
			idList.add(retrievedBookId);
		}
		return idList;
	}

	public LinkedList<BookBean> getBooksInfo() {
		return DataBase.book;
	}

	public List<StudentBean> showUsers() {
		List<StudentBean> usersList = new LinkedList<StudentBean>();
		for (StudentBean studentBean : DataBase.student) {

			studentBean.getStudentId();
			studentBean.getStudentName();
			studentBean.getEmail();
			studentBean.getBooksBorrowed();
			usersList.add(studentBean);

		}
		return usersList;
	}

	public List<RequestBean> showRequests() {
		List<RequestBean> infos = new LinkedList<RequestBean>();
		for (RequestBean requestInfo : DataBase.request) {
			requestInfo.getBookInfo();
			requestInfo.getStudentInfo();
			requestInfo.isIssued();
			requestInfo.isReturned();
			infos.add(requestInfo);
		}
		return infos;
	}

	public boolean bookIssue(StudentBean student, BookBean book) {
		boolean isValid = false;
		calendar.add(Calendar.DATE, 15);
		expectedReturnDate = calendar.getTime();

		RequestBean requestInfo = new RequestBean();

		int noOfBooksBorrowed = student.getBooksBorrowed();
		for (RequestBean info : DataBase.request) {
			if (info.getStudentInfo().getStudentId() == student.getStudentId()) {
				if (info.getBookInfo().getBookId() == book.getBookId()) {
					requestInfo = info;

					isValid = true;

				}
			}
		}

		if (isValid)

		{
			for (BookBean info2 : DataBase.book) {
				if (info2.getBookId() == book.getBookId()) {
					book = info2;
				}

			}

			for (StudentBean studentInfo : DataBase.student) {
				if (studentInfo.getStudentId() == student.getStudentId()) {
					student = studentInfo;
					noOfBooksBorrowed = student.getBooksBorrowed();

				}

			}

			if (noOfBooksBorrowed < 3) {

				boolean isRemoved = DataBase.book.remove(book);
				if (isRemoved) {

					noOfBooksBorrowed++;
					System.out.println(noOfBooksBorrowed);
					student.setBooksBorrowed(noOfBooksBorrowed);
					// DataBase.REQUESTDB.remove(requestInfo);
					requestInfo.setIssued(true);
					requestInfo.setIssuedDate(date);
					requestInfo.setExpectedReturnedDate(expectedReturnDate);
					return true;
				} else {
					throw new LMSException("Book can't be borrowed");
				}

			} else {
				throw new LMSException("Student Exceeds maximum limit");
			}

		} else {
			throw new LMSException("Book data or Student data is incorrect");

		}
	}

	public boolean isBookReceived(StudentBean student,BookBean book) {

		boolean isValid = false;
		RequestBean requestInfo1 = new RequestBean();
		for (RequestBean requestInfo : DataBase.request) {

			if (requestInfo.getBookInfo().getBookId() == book.getBookId()
					&& requestInfo.getStudentInfo().getStudentId() == student.getStudentId() 
					&& requestInfo.isReturned() == true) {
				isValid = true;
				requestInfo1 = requestInfo;
			}
		}
		if (isValid) {

			book.setBookAuthor(requestInfo1.getBookInfo().getBookAuthor());
			book.setBookName(requestInfo1.getBookInfo().getBookName());
			book.setCategory(requestInfo1.getBookInfo().getCategory());
			book.setPublisherName(requestInfo1.getBookInfo().getPublisherName());
			DataBase.book.add(book);
			DataBase.request.remove(requestInfo1);


			for (StudentBean userInfo2 : DataBase.student) {
				if (userInfo2.getStudentId() == student.getStudentId()) {
					student = userInfo2;
				}

			}
			int noOfBooksBorrowed = student.getBooksBorrowed();
			noOfBooksBorrowed--;
			student.setBooksBorrowed(noOfBooksBorrowed);
			return true;

		}

		return false;
	}
	/*
	 * public boolean updateBook(String email, String oldPassword, String
	 * newPassword) {
	 * 
	 * try { AdminBean adminInfo = DataBase.admin.get(email); if
	 * (adminInfo.getEmail().equals(email) &&
	 * adminInfo.getPassword().equals(oldPassword)) {
	 * adminInfo.setPassword(newPassword); DataBase.admin.put(email,adminInfo);
	 * return true; } else { throw new AdminException("Invalid Credentils"); }
	 * 
	 * } catch (Exception e) { throw new AdminException("Id Not Vaild"); } }
//	 */
	}