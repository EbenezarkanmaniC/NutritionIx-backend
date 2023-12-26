package com.userservice.kafkaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.userservice.model.UserRegistrationMessage;

@Service
public class KafkaService {	
	
	@Value("${Topic}")
	String topic;
	@Autowired
	private ObjectMapper objectMapper;
	
	  @Autowired
	  private KafkaTemplate<String, String> kafkaTemplate;
	
	  public void sendMessage(UserRegistrationMessage userRegistrationMessage) throws JsonProcessingException {
		  String userRegistrationMessageString=objectMapper.writeValueAsString(userRegistrationMessage);
	    kafkaTemplate.send(topic, userRegistrationMessageString);
	    System.out.println("topic: "+topic+"message sent: "+userRegistrationMessageString);
	  }

}
