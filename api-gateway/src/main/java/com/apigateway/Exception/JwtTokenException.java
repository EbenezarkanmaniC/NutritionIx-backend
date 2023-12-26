package com.apigateway.Exception;

import org.springframework.http.HttpStatus;

public class JwtTokenException extends Exception {
	private static final long serialVersionUID = 1L;
	public HttpStatus httpstatus;

	public JwtTokenException(HttpStatus httpstatus, String message) {
		super(message);
		this.httpstatus = httpstatus;
	}

	public HttpStatus getStatus() {
		return httpstatus;
	}
}
