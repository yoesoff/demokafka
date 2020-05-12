package com.beanary.demokafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class KafkaController {
	
	Logger logger = LoggerFactory.getLogger(KafkaController.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	private Gson jsonConverter;
	
	@PostMapping("/hello")
	public void hello(@RequestBody UserModel user) {
		logger.info("Produce User: {} from {}", user.getName(), user.getAddress());
		kafkaTemplate.send("demoTopicKafka", jsonConverter.toJson(user));
	}
}
