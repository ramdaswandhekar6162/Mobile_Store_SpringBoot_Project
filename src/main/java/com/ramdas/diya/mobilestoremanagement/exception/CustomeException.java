package com.ramdas.diya.mobilestoremanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomeException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public CustomeException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}
