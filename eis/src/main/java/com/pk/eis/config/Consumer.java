package com.pk.eis.config;


import javax.jms.JMSException;
import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pk.eis.IService.IMailService;
import com.pk.eis.model.Employee;
@Component
public class Consumer {
	private Logger log = LoggerFactory.getLogger(Consumer.class);
	
	@Autowired
	IMailService iMailService;
	
	@JmsListener(destination = "inbound.queue")
	@SendTo("outbound.queue")
	public String receiveMessage(final String message) throws JMSException, JsonProcessingException, MessagingException {
		System.out.println("Received message " + message);
		ObjectMapper mapper = new ObjectMapper();
		Employee emp = mapper.readValue(message, Employee.class);
		iMailService.sendMail(emp);

		return message;
	}
}
