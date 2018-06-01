package com.example.demo;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@EnableJms
@SpringBootApplication
@RestController
public class MsfJmsWithQueProducerApplication {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	Queue queue;

	public static void main(String[] args) {
		SpringApplication.run(MsfJmsWithQueProducerApplication.class, args);
	}
	
	@RequestMapping("/send/{message}")
	public String sendMessage(@PathVariable("message") final String message) {
		jmsTemplate.convertAndSend(queue, message);
		return "success";
	}
}
