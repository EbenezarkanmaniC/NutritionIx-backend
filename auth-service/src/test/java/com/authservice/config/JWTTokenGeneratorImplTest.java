package com.authservice.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.authservice.model.User;
class JWTTokenGeneratorImplTest {
  private static final String SECRET_KEY = "20ppaxinoitirtun2320ppaxinoitirtun23oitirtun2320ppaxinoitiroitirtun2320ppaxinoitir20ppaxinoitirtun2320ppaxinoitirtun23oitirtun2320ppaxinoitiroitirtun2320ppaxinoitir";
  @Test
  void testGenerateToken() throws UnsupportedEncodingException {
    JWTTokenGeneratorImpl tokenGenerator = new JWTTokenGeneratorImpl();
    User user = new User("phone","pass"); 
    String message = "Test message";
    Map<String, String> tokenMap = tokenGenerator.generateToken(user, SECRET_KEY, message);
    assertNotNull(tokenMap);
    assertTrue(tokenMap.containsKey("Token"));
    assertTrue(tokenMap.containsKey("Message"));
    assertNotNull(tokenMap.get("Token"));
    assertEquals(message, tokenMap.get("Message"));
  }
 
}