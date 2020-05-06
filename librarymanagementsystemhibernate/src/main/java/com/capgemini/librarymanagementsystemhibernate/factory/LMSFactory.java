package com.capgemini.librarymanagementsystemhibernate.factory;

import com.capgemini.librarymanagementsystemhibernate.dao.UserDAO;
import com.capgemini.librarymanagementsystemhibernate.dao.UserDAOImplement;
import com.capgemini.librarymanagementsystemhibernate.service.UserService;
import com.capgemini.librarymanagementsystemhibernate.service.UserServiceImplementation;

public class LMSFactory {
	
		public static UserDAO getUserDao() {
			return new UserDAOImplement();
		}
		public static UserService getUserService() {
			return new UserServiceImplementation();
		}
}
