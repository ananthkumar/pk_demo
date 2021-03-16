package com.pk.eis.IService;

import org.springframework.jms.JmsException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pk.eis.model.Employee;

@Service
public interface INotificationService {

	void send(Employee emp) throws JmsException, JsonProcessingException;
}
