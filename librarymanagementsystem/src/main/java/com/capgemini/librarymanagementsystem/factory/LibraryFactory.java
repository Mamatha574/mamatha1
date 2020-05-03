package com.capgemini.librarymanagementsystem.factory;

import com.capgemini.librarymanagementsystem.dao.AdminDAO;

import com.capgemini.librarymanagementsystem.dao.AdminDAOImplementation;
import com.capgemini.librarymanagementsystem.dao.StudentDAO;
import com.capgemini.librarymanagementsystem.dao.StudentDAOImplementation;
import com.capgemini.librarymanagementsystem.service.AdminServiceDAO;
import com.capgemini.librarymanagementsystem.service.AdminServiceImplementation;
import com.capgemini.librarymanagementsystem.service.StudentServiceDAO;
import com.capgemini.librarymanagementsystem.service.StudentServiceImplementation;


public class LibraryFactory {
	public static AdminDAO getAdminDao() {
		return new AdminDAOImplementation();
	}
	public static AdminServiceDAO getAdminService() {
		return new AdminServiceImplementation();
	}
	public static StudentDAO getUserDao() {
		return new StudentDAOImplementation();
	}
	public static StudentServiceDAO getUserService() {
		return new StudentServiceImplementation();
	}
}