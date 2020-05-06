package com.capgemini.librarymanagementsystemjdbc.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.librarymanagementsystemjdbc.exception.LMSException;
public class Validation {
	public boolean validatedId(int id) throws LMSException {
		String idRegEx = "[0-9]{1}[0-9]{4}" ;
		boolean result = false;
		if (Pattern.matches(idRegEx, String.valueOf(id))) {
			result = true;
		} else {
			throw new LMSException("Id should contain exactly 5 digits");
		}
		return result;
	}
	public boolean validatedName(String name) throws LMSException {
		String nameRegEx = "^[A-Za-z\\s]{3,}[\\.]{0,1}[A-Za-z\\s]{0,}$" ;
		boolean result = false;
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new LMSException("Name should contain atleast 3 characters and only alphabets");
		}
		return result;
	}
	public boolean validatedMobile(long mobile) throws LMSException {
		String mobileRegEx = "(0/91)?[6-9][0-9]{9}" ;
		boolean result = false;
		if (Pattern.matches(mobileRegEx, String.valueOf(mobile))) {
			result = true;
		} else {
			throw new LMSException("Mobile Number  will start between  6 to 9 and It should contain 10 numbers");
		}
		return result;
	}
	public boolean validatedEmail(String email) throws LMSException {
		String emailRegEx = "[\\w&&[^_]]{3,50}[@]{1}\\D{2,50}[.]{1}\\D{2,50}";
		boolean result = false;
		Pattern pattern = Pattern.compile(emailRegEx);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new LMSException("Enter Correct Email (@ and extensions(.com))");
		}
		return result;
	}
	public boolean validatedPassword(String password) throws LMSException {
		String passwordRegEx = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{4,20})" ;
		boolean result = false;
		if (Pattern.matches(passwordRegEx, String.valueOf(password))) { 
			result = true;
		} else {
			throw new LMSException("Password should contain atleast one digit,one uppercase,one lowercase,one symbol(@#$%)"); 
		}
		return result;
	}
	}

