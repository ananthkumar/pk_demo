package com.pk.eis.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.pk.eis.iservice.IMailService;
import com.pk.eis.model.Employee;

@Service
public class MailService implements IMailService{
    @Autowired
    private JavaMailSender mailSender;
    
    @Value("${spring.mail.username}")
    private String  mailId;
     
    public void sendMail(Employee emp) throws MessagingException {

    	String from = mailId;
    	String to = emp.getEmail();
    	 
    	 
    	MimeMessage message = mailSender.createMimeMessage();
    	MimeMessageHelper helper = new MimeMessageHelper(message);
    	helper.setSubject("Welcome to PK.");
    	helper.setFrom(from);
    	helper.setTo(to);
    	 
    	boolean html = true;
    	helper.setText("<b>Hey "+emp.getName().toUpperCase()+"</b>,<br><i>Welcome to PK.<br>Your Onboarding successful.</i>", html);
    	 
    	mailSender.send(message);
    }

	
}
