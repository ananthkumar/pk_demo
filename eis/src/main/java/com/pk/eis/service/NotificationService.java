package com.pk.eis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pk.eis.iservice.INotificationService;
import com.pk.eis.model.Employee;

@Service
public class NotificationService implements INotificationService {

    @Autowired 
    private JmsTemplate jmsTemplate;
    
    @Value("${queue.name}")
    private String queue;

	@Override
	public void send(Employee emp) throws JmsException, JsonProcessingException {
		ObjectMapper om= new ObjectMapper();
		
        jmsTemplate.convertAndSend(queue, om.writeValueAsString(emp));


	}

}
