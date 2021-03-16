package com.pk.eis.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employeeDependent")
public class EmpDependent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int DependentId;
	@Column
	private String DependentName;
	@Column
	private String DependentRelation;
	@Column
	private Date DependentDob;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Employee emp;

	public int getDependentId() {
		return DependentId;
	}

	public void setDependentId(int dependentId) {
		DependentId = dependentId;
	}

	public String getDependentName() {
		return DependentName;
	}

	public void setDependentName(String dependentName) {
		DependentName = dependentName;
	}

	public String getDependentRelation() {
		return DependentRelation;
	}

	public void setDependentRelation(String dependentRelation) {
		DependentRelation = dependentRelation;
	}

	public Date getDependentDob() {
		return DependentDob;
	}

	public void setDependentDob(Date dependentDob) {
		DependentDob = dependentDob;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

}
