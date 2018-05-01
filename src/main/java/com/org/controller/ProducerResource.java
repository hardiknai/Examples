package com.org.controller;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerResource {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue queue;
	
	@GetMapping("/publish/{message}")
	public String publisher(@PathVariable("message") String message) {
		jmsTemplate.convertAndSend(queue, message);
		return "Published Sucessfully.";
	}
}
