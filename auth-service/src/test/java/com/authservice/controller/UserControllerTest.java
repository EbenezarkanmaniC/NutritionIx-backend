package com.authservice.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.authservice.config.JWTTokenGenerator;
import com.authservice.config.JWTTokenGeneratorImpl;
import com.authservice.exception.UserDoesNotExist;
import com.authservice.model.User;
import com.authservice.service.UserService;
import com.authservice.service.UserServiceImpl;

@SpringBootTest
class UserControllerTest {
	@Mock
	UserService userService = new UserServiceImpl();
	@Mock
	JWTTokenGenerator jwtTokenGenerator = new JWTTokenGeneratorImpl();
	@InjectMocks
	UserController userController = new UserController();

	@Test
	void testLoginSuccessful() throws UserDoesNotExist, UnsupportedEncodingException {
		// Arrange
		User mockUser = new User("testPhoneNumber", "testPassword");
		mockUser.setPassword("testPassword");
		mockUser.setPhoneNumber("testPhoneNumber");
		when(userService.getUserNameandPassword(anyString(), anyString())).thenReturn(mockUser);
		Map<String, String> jwtTokenMap = new HashMap<>();
		jwtTokenMap.put("Token", "mockToken");
		jwtTokenMap.put("Message", "message");
		when(jwtTokenGenerator.generateToken(mockUser, "secret", "message")).thenReturn(jwtTokenMap);
		// Act
		ResponseEntity<?> responseEntity = userController.login(mockUser);
		// Assert
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		
	}

	@Test
  void testLoginUserDoesNotExist() throws UserDoesNotExist, UnsupportedEncodingException {
    // Arrange
    when(userService.getUserNameandPassword(anyString(), anyString())).thenThrow(new UserDoesNotExist(HttpStatus.NOT_FOUND, "User doesn't exist"));
    // Act and Assert
    assertThrows(UserDoesNotExist.class, () -> userController.login(new User("nonexistentPhoneNumber", "testPassword")));
  }
	// Add more test cases as needed for different scenarios.
}
