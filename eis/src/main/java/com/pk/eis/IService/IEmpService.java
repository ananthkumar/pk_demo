package com.pk.eis.iservice;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.jms.JmsException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pk.eis.model.Employee;

@Service
public interface IEmpService {

	public List<Employee> findAll();
    public void save(Employee emp) throws JmsException, JsonProcessingException, MessagingException;
    public Employee get(Integer id);
    public void delete(Integer id);

}
