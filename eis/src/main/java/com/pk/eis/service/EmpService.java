package com.pk.eis.service;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pk.eis.iservice.IEmpService;
import com.pk.eis.iservice.INotificationService;
import com.pk.eis.model.Employee;
import com.pk.eis.repository.EmployeeRepo;

@Service
public class EmpService implements IEmpService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	INotificationService iNotificationService;
	
	
	public List<Employee> findAll() {
		return  employeeRepo.findAll();
	}
	
	public void save(Employee emp) throws JmsException, JsonProcessingException, MessagingException {
		employeeRepo.save(emp);
		iNotificationService.send(emp);
	}
	
	public Employee get(Integer id) {
		Optional<Employee> empOpt = employeeRepo.findById(id);
		if(empOpt.isPresent()) {
			return empOpt.get();
		}
        return null;
    }
     
    public void delete(Integer id) {
    	employeeRepo.deleteById(id);
    }

}
