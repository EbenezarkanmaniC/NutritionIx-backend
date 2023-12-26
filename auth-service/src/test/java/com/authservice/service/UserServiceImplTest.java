package com.authservice.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.authservice.exception.UserDoesNotExist;
import com.authservice.model.User;
import com.authservice.repository.UserRepository;
class UserServiceImplTest {
  private UserRepository userRepository;
  private UserServiceImpl userService;
  @BeforeEach
  void setUp() {
    userRepository = mock(UserRepository.class);
    userService = new UserServiceImpl();
    userService.userRepository = userRepository;
  }
  @Test
  void testGetUserNameandPassword_UserExists() throws UserDoesNotExist {
    // Arrange
    String userName = "existingUser";
    String password = "password";
    User expectedUser = new User(); 
    when(userRepository.findByPhoneNumberAndPassword(userName, password)).thenReturn(expectedUser);
    
    User actualUser = userService.getUserNameandPassword(userName, password);
   
    assertEquals(expectedUser, actualUser);
  }
  @Test
  void testGetUserNameandPassword_UserDoesNotExist() {
    
    String userName = "nonexistentUser";
    String password = "password";
    when(userRepository.findByPhoneNumberAndPassword(userName, password)).thenReturn(null);
   
    assertThrows(UserDoesNotExist.class, () -> userService.getUserNameandPassword(userName, password));
  }
}
