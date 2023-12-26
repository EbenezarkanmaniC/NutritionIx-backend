package com.authservice.kafkaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.authservice.model.User;
import com.authservice.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaService {
	
	@Value("${Topic}")
	private String topic;
	
	
	@Value("${group-id}")
	private String groupId;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	UserRepository userRepository;
	
	@KafkaListener(topics = "${Topic}", groupId = "${group-id}")
	public void consumer(String user) throws JsonMappingException, JsonProcessingException {
		User jsonUser=objectMapper.readValue(user, User.class);
		userRepository.save(jsonUser);
	System.out.println("------------------------------- "+jsonUser.getPhoneNumber()+"---------------------------");
	}

}
