package com.pk.eis.iservice;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

import com.pk.eis.model.Employee;

@Service
public interface IMailService {
	
	public void sendMail(Employee emp) throws MessagingException;

}
