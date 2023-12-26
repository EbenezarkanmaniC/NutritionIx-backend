package com.authservice.service;

import com.authservice.exception.UserDoesNotExist;
import com.authservice.model.User;

public interface UserService {

		User getUserNameandPassword(String userName, String password) throws UserDoesNotExist;

}
