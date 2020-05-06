package com.capgemini.librarymanagementsystem.dao;


import java.util.ArrayList;

import com.capgemini.librarymanagementsystem.db.DataBase;
import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.StudentBean;
import com.capgemini.librarymanagementsystem.exception.LMSException;


public class StudentDAOImplementation implements StudentDAO {

	public boolean register(StudentBean std) {
		for (StudentBean studentbean : DataBase.student) {
			if (studentbean.getEmail().equals(std.getEmail())) {
				return false;
			}

		}
		DataBase.student.add(std);
		return true;
	}


	public StudentBean auth(String regEmail1, String regPassword1) {
		for (StudentBean bean : DataBase.student) {
			if (bean.getEmail().equals(regEmail1) && bean.getPassword().equals(regPassword1)) {
				System.out.println("Login Successful");
				return bean;
			} 
			throw new LMSException ("Invalid email and password");

		}
		return null;
	}


	public ArrayList<BookBean> searchBookTitle(String bookName) {
		ArrayList<BookBean> searchList=new ArrayList<BookBean>();
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
			throw new LMSException ("Book is not found");
		}
		else
		{
			return searchList;
		}
	}


	public ArrayList<BookBean> searchBookAuthor(String bookAuthor) {
		ArrayList<BookBean> searchList=new ArrayList<BookBean>();
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
			throw new LMSException ("Book is not found");
		}
		else
		{
			return searchList;
		}	
	}


	public ArrayList<BookBean> searchBookType(String bookType) {
		ArrayList<BookBean> searchList=new ArrayList<BookBean>();
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


	public ArrayList<Integer> getBookIds() {
		ArrayList<Integer> idList=new ArrayList<Integer>();
		for(int i=0;i<=DataBase.book.size()-1;i++)
		{
			BookBean retrievedBook=DataBase.book.get(i);
			int retrievedBookId=retrievedBook.getBookId();
			idList.add(retrievedBookId);
		}
		return idList;

	}


	public ArrayList<BookBean> getBooksInfo() {
		return DataBase.book;
	}


	public RequestBean bookRequest(StudentBean student, BookBean book) {
		
		boolean flag = false, 
		isRequestExists = false;
		RequestBean requestInfo = new RequestBean();
		StudentBean userInfo2 = new StudentBean();
		BookBean bookInfo2 = new BookBean();

		for (RequestBean requestInfo2 : DataBase.request) {
			if (book.getBookId() == requestInfo2.getBookInfo().getBookId()) {
				isRequestExists = true;

			}

		}

		if (!isRequestExists) {
			for (StudentBean user : DataBase.student) {
				if (user.getStudentId() == student.getStudentId()) {
					for (BookBean book1 : DataBase.book) {
						if (book1.getBookId() == book1.getBookId()) {
							userInfo2 = user;
							bookInfo2 = book1;
							flag = true;
						}
					}
				}
			}
			if (flag == true) {
				requestInfo.setBookInfo(bookInfo2);
				requestInfo.setStudentInfo(userInfo2);
				DataBase.request.add(requestInfo);
				return requestInfo;
			}

		}

		throw new LMSException("Invalid request or you cannot request that book");
	}


	public RequestBean bookReturn(StudentBean student, BookBean book) {
		for (RequestBean requestInfo : DataBase.request) {

			if (requestInfo.getBookInfo().getBookId() == book.getBookId() &&
					requestInfo.getStudentInfo().getStudentId() == student.getStudentId() &&
					requestInfo.isIssued() == true) {


				System.out.println("Returning Issued book only");
				requestInfo.setReturned(true);


				return requestInfo;
			}

		}

		throw new  LMSException("Invalid return ");
	}

}