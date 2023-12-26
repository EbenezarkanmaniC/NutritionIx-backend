package com.wishlistservice.Exception;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.http.HttpStatus;

import com.wishlistservice.model.Wishlist;

public class EmptyWishlistException extends Exception {
	
	private HttpStatus httpstatus;

	public EmptyWishlistException(HttpStatus httpstatus, String message) {
		super(message);
		this.httpstatus=httpstatus;		
	}
	
	public HttpStatus getStatus() {
		return httpstatus;
	}

}