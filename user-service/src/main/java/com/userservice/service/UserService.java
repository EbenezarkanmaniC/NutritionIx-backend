package com.userservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userservice.exception.UserDoesNotExist;
import com.userservice.model.User;


public interface UserService {
	
	User signUp(User user) throws JsonProcessingException;
	
	User getUserById(long id) throws UserDoesNotExist;
	
	User updateUser(User user) throws UserDoesNotExist;
	
	void deleteUser(long id);
	
	String getCountry(long id);

}
