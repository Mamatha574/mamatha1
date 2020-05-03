package com.capgemini.librarymanagementsystemjdbc.dto;

public class BookBean {
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private String category;
	private String publisher;
	//private int copies;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	/*
	 * public int getCopies() { return copies; } public void setCopies(int copies) {
	 * this.copies = copies; }
	 */
}


