package com.pk.eis.service;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jms.JmsException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pk.eis.iservice.INotificationService;
import com.pk.eis.model.Employee;
import com.pk.eis.repository.EmployeeRepo;
import com.pk.eis.vo.User;

class EmpServiceTest {

	@Mock
	private EmployeeRepo employeeRepo;

	@Mock
	private INotificationService iNotificationService;

	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void findAllTest() {
		User user = new User("John", "Software Engineer", "2021-02-02", "leela1.gopi@gamil.com", " Hyderabad",
				"9542128262");

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
	void saveTest(Employee emp) throws JmsException, JsonProcessingException {
		when(employeeRepo.save((Employee) any(Employee.class))).thenReturn(new Employee());
		Employee empSave = new Employee();
		assertNotEquals(null, employeeRepo.save(empSave));

		doNothing().when(iNotificationService).send(empSave);
		verify(iNotificationService, times(1)).send(empSave);

	}
}
