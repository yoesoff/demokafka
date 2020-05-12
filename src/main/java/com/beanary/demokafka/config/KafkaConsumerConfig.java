package com.beanary.demokafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.beanary.demokafka.UserModel;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		Map<String, Object> configs = new HashMap<>();

		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "KafkaGroupDemo");
		// add trusted
//		JsonDeserializer<UserModel> deserializer = new JsonDeserializer<>();
//	    deserializer.addTrustedPackages("com.beanary.demokafka");
		
		return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), new StringDeserializer());
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> 
			kafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
		
		kafkaListenerContainerFactory.setConsumerFactory(consumerFactory());
		
		return kafkaListenerContainerFactory;
	}
}
