package com.userservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.userservice.exception.UserAlreadyPresentException;
import com.userservice.exception.UserDoesNotExist;
import com.userservice.model.User;
import com.userservice.service.UserService;
@SpringBootTest
class UserControllerTest {
	
	@InjectMocks
	UserController userController;
	
	private MockMvc mockMvc;
	
	@Mock
	UserService userService;
	
	User user=new User();
	ResponseEntity<User> response=null;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
		user= new User();
		user.setCountry("india");
		user.setEmail("email@email.com");
		user.setPhoneNumber("8080808080");
		user.setUserId(1);
		user.setUserName("name");
		response=new ResponseEntity<User>(user,HttpStatus.OK);		
	}
	@Test
	void testSignUp() throws Exception {		
		when(userService.signUp(user)).thenReturn(user);
		assertEquals(userController.signUp(user), response);		
	}
	
	@Test
	void testSignUpException() throws Exception {
		
		when(userService.signUp(user)).thenReturn(user);
    	Exception exception=assertThrows(UserAlreadyPresentException.class, ()->userController.signUp(null));
    	assertEquals("User is not available to register", exception.getMessage());
		
	}

	@Test
	void testGetUserById() throws UserDoesNotExist {
		when(userService.getUserById(1)).thenReturn(user);
		assertEquals(response, userController.getUserById(1));
		
	}

	@Test
	void testUpdateUser() throws UserDoesNotExist {
		when(userService.updateUser(user)).thenReturn(user);
		assertEquals(userController.updateUser(user), response);
	}
	@Test
	void testUpdateUserException() throws UserDoesNotExist {

		when(userService.updateUser(user)).thenReturn(user);
    	Exception exception=assertThrows(NullPointerException.class, ()->userController.updateUser(null));
    	assertEquals("User request body is empty to update", exception.getMessage());
	}

	@Test
	void testDeleteUser() {
		doNothing().when(userService).deleteUser(1);
		assertEquals(response.getStatusCodeValue(), userController.deleteUser(1).getStatusCodeValue());
	}

	@Test
	void testGetCountryById() {
		when(userService.getCountry(1)).thenReturn("india");
		assertEquals(response.getStatusCodeValue(), userController.getCountryById(1).getStatusCodeValue());
	}

}
