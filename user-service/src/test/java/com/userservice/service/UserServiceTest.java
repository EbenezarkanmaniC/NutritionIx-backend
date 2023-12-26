package com.userservice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userservice.exception.UserAlreadyPresentException;
import com.userservice.exception.UserDoesNotExist;
import com.userservice.kafkaService.KafkaService;
import com.userservice.model.User;
import com.userservice.repository.UserRepository;
import com.userservice.serviceImpl.UserServiceImpl;

@SpringBootTest
class UserServiceTest {
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	KafkaService kafkaService;
	
	@InjectMocks
	UserService userService=new UserServiceImpl();
	
	User user=new User();
	User user2=new User();
	ResponseEntity<User> response=null;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userService).build();
		user= new User();
		user.setPassword("hello");
		user.setCountry("india");
		user.setEmail("email@email.com");
		user.setPhoneNumber("8080808080");
		user.setUserId(1);
		user.setUserName("name");
		
		response=new ResponseEntity<User>(user,HttpStatus.OK);		
	}

	@Test
	void testSignUp() throws JsonProcessingException {
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(userService.signUp(user), user);
	}

	@Test
	void testGetUserById() throws UserDoesNotExist {
		when(userRepository.findById((long) 1)).thenReturn(Optional.of(user));
		assertEquals(userService.getUserById(1), user);
	}

	@Test
	void testGetUserByIdException() throws UserDoesNotExist {
		when(userRepository.findById((long) 1)).thenReturn(Optional.ofNullable(null));
    	Exception exception=assertThrows(UserDoesNotExist.class, ()->userService.getUserById(1));
    	assertEquals(user.getUserId()+" doesnot exist", exception.getMessage());
	}
	@Test
	void testUpdateUser() throws UserDoesNotExist {
		when(userRepository.save(user)).thenReturn(user);
		when(userRepository.findById((long) 1)).thenReturn(Optional.of(user));
		assertEquals(userService.updateUser(user), user);
	}
	@Test
	void testUpdateUserException() throws UserDoesNotExist {
		when(userRepository.findById((long) 1)).thenReturn(Optional.ofNullable(null));
    	Exception exception=assertThrows(UserDoesNotExist.class, ()->userService.updateUser(user));
    	assertEquals("User doesn't exist to update", exception.getMessage());
	}

	@Test
	void testDeleteUser() {
		doNothing().when(userRepository).deleteById((long) 1);
		userService.deleteUser(1);
		assertTrue(true);
	}

	@Test
	void testGetCountry() {
		when(userRepository.findById((long) 1)).thenReturn(Optional.of(user));
		assertEquals(userService.getCountry(1), "india");
	}

}
