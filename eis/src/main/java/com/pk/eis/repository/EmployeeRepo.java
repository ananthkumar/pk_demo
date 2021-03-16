package com.pk.eis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pk.eis.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	public List<Employee> findAll();
    @SuppressWarnings("unchecked")
	public Employee save(Employee emp);
    public Employee get(Integer id);
    public void delete(Integer id);

}
