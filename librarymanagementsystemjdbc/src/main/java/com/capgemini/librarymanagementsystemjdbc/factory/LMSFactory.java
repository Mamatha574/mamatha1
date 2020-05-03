package com.capgemini.librarymanagementsystemjdbc.factory;

import com.capgemini.librarymanagementsystemjdbc.dao.UserDAO;
import com.capgemini.librarymanagementsystemjdbc.dao.UserDAOImplement;
import com.capgemini.librarymanagementsystemjdbc.service.UserService;
import com.capgemini.librarymanagementsystemjdbc.service.UserServiceImplementation;

public class LMSFactory {
	public static UserDAO getUserDao() {
		return new UserDAOImplement();
	}
	public static UserService getUserService() {
		return new UserServiceImplementation();
	}
}
