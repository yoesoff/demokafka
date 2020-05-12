package com.beanary.demokafka.config;

import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

@Configuration
public class Config {
	public Gson jsonConverter() {
		return new Gson();
	}
}
