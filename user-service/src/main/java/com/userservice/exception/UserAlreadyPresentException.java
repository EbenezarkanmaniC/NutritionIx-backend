package com.userservice.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class UserAlreadyPresentException extends Exception{
	
	public HttpStatus httpstatus;
	
	public UserAlreadyPresentException(HttpStatus httpstatus,String message){
		super( message);
		this.httpstatus=httpstatus;
	}
	public HttpStatus getStatus() {
		return httpstatus;
	}
}
