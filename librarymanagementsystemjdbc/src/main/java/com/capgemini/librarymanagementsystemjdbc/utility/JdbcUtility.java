package com.capgemini.librarymanagementsystemjdbc.utility;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;



public class JdbcUtility {

	private static Connection con = null;

	static {
		try {
			FileInputStream info = new FileInputStream("db.properties");
			Properties pro = new Properties();
			pro.load(info);

			String url = pro.getProperty("url");
			String user = pro.getProperty("username");
			String pass = pro.getProperty("password");
			String driverClass = pro.getProperty("driverClass");

			Class.forName(driverClass);
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return con;
	}

}
