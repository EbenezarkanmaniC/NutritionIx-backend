package com.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.authservice.config.JWTTokenGenerator;
import com.authservice.config.JWTTokenGeneratorImpl;
import com.authservice.exception.UserDoesNotExist;
import com.authservice.model.User;
import com.authservice.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	JWTTokenGenerator jwtTokenGenerator=new JWTTokenGeneratorImpl();
	
	@Value("${app.jwt.secret}")
    private String SECRET_KEY;


	@Override
	public User getUserNameandPassword(String userName, String password) throws UserDoesNotExist {
		System.out.println(userName+" usernamepassword "+password);
		User user=userRepository.findByPhoneNumberAndPassword(userName, password);
		if(user!=null) {
				
			return user;
		}
		else {
			throw new UserDoesNotExist(HttpStatus.NOT_FOUND, "User doesn't exist");
		}
	}

	
}
