package com.beanary.demokafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class ConsumerService {

	Logger logger = LoggerFactory.getLogger(ConsumerService.class);
	@Autowired
	private Gson jsonConverter;
	
	@KafkaListener(topics = "demoTopicKafka")
	public void userFromKafka(String strUser) {
		UserModel user = (UserModel) jsonConverter.fromJson(strUser, UserModel.class); 
		
		logger.info("Consumer1 User: {} from {}", user.getName(), user.getAddress());
	}
}
