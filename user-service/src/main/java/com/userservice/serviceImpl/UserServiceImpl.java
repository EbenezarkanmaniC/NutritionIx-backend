package com.userservice.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userservice.exception.UserDoesNotExist;
import com.userservice.kafkaService.KafkaService;
import com.userservice.model.User;
import com.userservice.model.UserRegistrationMessage;
import com.userservice.repository.UserRepository;
import com.userservice.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	KafkaService kafkaService;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User signUp(User user) throws JsonProcessingException {	
		UserRegistrationMessage userRegistrationMessage=new UserRegistrationMessage();
		userRegistrationMessage.setPhoneNumber(user.getPhoneNumber());
		userRegistrationMessage.setPassword(user.getPassword());
		kafkaService.sendMessage(userRegistrationMessage);
		return userRepository.save(user);
	}

	@Override
	public User getUserById(long id) throws UserDoesNotExist {
		Optional<User> user=userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		else {
		throw new UserDoesNotExist(HttpStatus.NOT_FOUND,id+" doesnot exist");
		}
	}

	@Override
	public User updateUser(User user) throws UserDoesNotExist{
		
		Optional<User> existingUser=userRepository.findById(user.getUserId());
		if(existingUser.isPresent()) {
			User updatedUser=existingUser.get();
			updatedUser.setUserId(user.getUserId());
			updatedUser.setUserName(user.getUserName());
			updatedUser.setEmail(user.getEmail());
			updatedUser.setCountry(user.getCountry());
			updatedUser.setPhoneNumber(user.getPhoneNumber());
			
			return userRepository.save(updatedUser);
		}
		else {
			throw new UserDoesNotExist(HttpStatus.NOT_FOUND,"User doesn't exist to update");
		}
	}	



	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public String getCountry(long id) {
		
		return userRepository.findById(id).get().getCountry();
	}
}