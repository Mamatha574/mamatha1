package com.capgemini.librarymanagementsystemspringrest.exception;

@SuppressWarnings("serial")
public class LMSException extends RuntimeException{
	public LMSException(String message) {
		super(message);
	}
}
