package com.authservice.service;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.authservice.kafkaService.KafkaService;
import com.authservice.model.User;
import com.authservice.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootTest
class KafkaServiceTest {
	@InjectMocks
  private KafkaService kafkaService;
	@Mock
  private ObjectMapper objectMapper;
	@Mock
  private UserRepository userRepository;
  @Value("${Topic}")
  private String topic;
  @Value("${group-id}")
  private String groupId;
  
  @Test
  void testConsumer() throws JsonMappingException, JsonProcessingException {
    // Given
    String userJson = "{\"phoneNumber\": \"1234567890\", \"otherField\": \"value\"}";
    User expectedUser = new User();
    expectedUser.setPhoneNumber("1234567890");
    when(objectMapper.readValue(userJson, User.class)).thenReturn(expectedUser);
    // When
    kafkaService.consumer(userJson);
    // Then
    verify(userRepository, times(1)).save(expectedUser);
  }
}




