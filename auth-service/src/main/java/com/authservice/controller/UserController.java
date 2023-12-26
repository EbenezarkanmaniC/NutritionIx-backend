package com.authservice.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authservice.config.JWTTokenGenerator;
import com.authservice.config.JWTTokenGeneratorImpl;
import com.authservice.exception.UserDoesNotExist;
import com.authservice.model.User;
import com.authservice.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins =  "http://localhost:4200")
public class UserController {
	
	@Value("${app.jwt.secret}")
    private String SECRET_KEY;
    
    @Value("${app.message}")
    private String message;
    
	@Autowired
	private UserService userService;
	
	private JWTTokenGenerator jwtTokenGenerator=new JWTTokenGeneratorImpl();
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) throws UserDoesNotExist, UnsupportedEncodingException {
		User user1= userService.getUserNameandPassword(user.getPhoneNumber(),user.getPassword());
		return new ResponseEntity<>(jwtTokenGenerator.generateToken(user1,SECRET_KEY,message),HttpStatus.CREATED);
	}

}
