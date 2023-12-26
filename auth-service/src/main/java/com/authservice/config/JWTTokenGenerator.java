package com.authservice.config;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.authservice.model.User;

public interface JWTTokenGenerator {
	public Map<String,String> generateToken(User user, String SECRET_KEY,String message) throws UnsupportedEncodingException;
	
}
