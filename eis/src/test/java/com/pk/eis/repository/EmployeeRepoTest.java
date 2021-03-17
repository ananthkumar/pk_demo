package com.pk.eis.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pk.eis.model.Employee;
import com.pk.eis.vo.User;

public class EmployeeRepoTest {

	@Autowired
	private EmployeeRepo employeeRepo;

	User user;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		user = new User().getDummyUser();

	}

	@Test
	void findAllTest() {

		List<Employee> list = new ArrayList<Employee>();
		Employee empOne = user.getEmployee(user);
		Employee empTwo = user.getEmployee(user);
		Employee empThree = user.getEmployee(user);
		empOne.setEmpId(1);
		empTwo.setEmpId(2);
		empThree.setEmpId(3);
		list.add(empOne);
		list.add(empTwo);
		list.add(empThree);

		when(employeeRepo.findAll()).thenReturn(list);

		List<Employee> empList = employeeRepo.findAll();
		assertEquals(3, empList.size());
	}

	@Test
	void saveTest() throws JmsException, JsonProcessingException, MessagingException {
		
		Employee empOne = user.getEmployee(user);
		empOne.setEmpId(1);
		when(employeeRepo.save(Mockito.any(Employee.class))).thenReturn(empOne);
		assertNotEquals(null, employeeRepo.save(new Employee()));

	}

}
