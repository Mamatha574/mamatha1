package com.capgemini.librarymanagementsystemhibernate.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "book_issue_details")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class BookIssuseBean {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seq")
	private int id;
	@Column
	private int bookId;
	@Column
	private int userId;
	@Column
	private Date issueDate;
	@Column
	private Date returnDate;
	
}
