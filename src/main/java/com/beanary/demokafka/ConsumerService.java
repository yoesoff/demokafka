package com.beanary.demokafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {

	Logger logger = LoggerFactory.getLogger(ConsumerService.class);
	
	@KafkaListener(topics = "demoTopicKafka", groupId = "KafkaGroupDemo")
	public void userFromKafka(UserModel user) {
		logger.info("Consumer User: {} ", user);
	}
	
}
