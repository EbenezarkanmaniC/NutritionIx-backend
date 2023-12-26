package com.userservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userservice.exception.UserAlreadyPresentException;
import com.userservice.exception.UserDoesNotExist;
import com.userservice.model.User;
import com.userservice.service.UserService;
@ControllerAdvice
@RestController
@RequestMapping("/api/nutrition/userdetails")
@CrossOrigin(origins =  "http://localhost:4200")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/saveUser")
	public ResponseEntity<User> signUp(@RequestBody User user) throws UserAlreadyPresentException, JsonProcessingException{
		if(user!=null) {
			return new ResponseEntity<User>(userService.signUp(user),HttpStatus.OK);
		}
		else {
			throw new UserAlreadyPresentException(HttpStatus.ALREADY_REPORTED,"User is not available to register");
		}
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable long id) throws UserDoesNotExist{
		
		return new ResponseEntity<User>(userService.getUserById(id),HttpStatus.OK);
		
	}
	@PutMapping("/user/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User user1) throws UserDoesNotExist{
		Optional<User> user=Optional.ofNullable(user1);
			if(user.isPresent()) {
				return new ResponseEntity<User>(userService.updateUser(user.get()),HttpStatus.OK);
			}
			else {
				throw new NullPointerException("User request body is empty to update");
			}			
	}
	
	@DeleteMapping("user/deleteUser/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable long id){
		userService.deleteUser(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@GetMapping("/user/country/{id}")
	public ResponseEntity<String> getCountryById(@PathVariable long id){
		return new ResponseEntity<String>(userService.getCountry(id),HttpStatus.OK);
	}
	
}
