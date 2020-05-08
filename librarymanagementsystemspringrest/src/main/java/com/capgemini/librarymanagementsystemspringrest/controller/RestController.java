package com.capgemini.librarymanagementsystemspringrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.librarymanagementsystemspringrest.dto.ResponseBean;
import com.capgemini.librarymanagementsystemspringrest.exception.LMSException;

@RestControllerAdvice
public class RestController {
	@ExceptionHandler
	public ResponseBean myExceptionHandler(LMSException lmsException) {
		ResponseBean response = new ResponseBean();
		response.setError(true);
		response.setMessage(lmsException.getMessage());
		return response;
	}
}
