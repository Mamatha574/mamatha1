package com.capgemini.librarymanagementsystemjdbc.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import com.capgemini.librarymanagementsystemjdbc.exception.LMSException;

public class Return {
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
							
							Date returnDate = cal.getTime();
							
							long difference = issueDate.getTime() - returnDate.getTime();
							
							float daysBetween = (difference / (60*60*24*1000));
							
							//float daysBetween = ((difference *1.1574074)/ (100000000));
							if(daysBetween>7) {
								float fine = daysBetween*5;
								System.out.println("The user has to pay the fine of the respective book of Rs:"+fine);
								if(status=="yes") {
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
