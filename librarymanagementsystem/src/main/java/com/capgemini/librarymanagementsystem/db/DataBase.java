package com.capgemini.librarymanagementsystem.db;


import java.util.ArrayList;

import com.capgemini.librarymanagementsystem.dto.AdminBean;
import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.StudentBean;

public class DataBase {
	public static final ArrayList<AdminBean> admin = new ArrayList<AdminBean>();
	public static final ArrayList<BookBean> book = new ArrayList<BookBean>();
	public static final ArrayList<StudentBean> student = new ArrayList<StudentBean>();
	public static final ArrayList<RequestBean> request = new ArrayList<RequestBean>();
	
	
public static void addToDatabase() {
		
		admin.add(new AdminBean(1,"Mamatha","mam@gmail.com",9010554823L,"Mamatha@1"));
		admin.add(new AdminBean(1,"Swathi","swa@gmail.com",9010554823L,"Swathi@1"));
		
		
		
		
						
	}
	
}