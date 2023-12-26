package com.authservice.exception;

import org.springframework.http.HttpStatus;

public class UserDoesNotExist extends Exception {
	private static final long serialVersionUID = 1L;
	public HttpStatus httpstatus;

	public UserDoesNotExist(HttpStatus httpstatus, String message) {
		super(message);
		this.httpstatus = httpstatus;
	}

	public HttpStatus getStatus() {
		return httpstatus;
	}
}
