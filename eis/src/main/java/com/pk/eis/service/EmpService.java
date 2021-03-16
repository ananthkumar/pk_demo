package com.pk.eis.service;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pk.eis.IService.IEmpService;
import com.pk.eis.IService.IMailService;
import com.pk.eis.IService.INotificationService;
import com.pk.eis.model.Employee;
import com.pk.eis.repository.EmployeeRepo;

@Service
public class EmpService implements IEmpService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	INotificationService iNotificationService;
	
	
	public List<Employee> findAll() {
		return (List<Employee>) employeeRepo.findAll();
	}
	
	public void save(Employee emp) throws JmsException, JsonProcessingException, MessagingException {
		employeeRepo.save(emp);
		iNotificationService.send(emp);
	}
	
	public Employee get(Integer id) {
        return employeeRepo.findById(id).get();
    }
     
    public void delete(Integer id) {
    	employeeRepo.deleteById(id);
    }

}
