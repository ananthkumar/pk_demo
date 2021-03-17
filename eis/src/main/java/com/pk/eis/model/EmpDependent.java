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
	private int dependentId;
	@Column
	private String dependentName;
	@Column
	private String dependentRelation;
	@Column
	private Date dependentDob;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Employee emp;

	public int getDependentId() {
		return dependentId;
	}

	public void setDependentId(int dependentId) {
		dependentId = dependentId;
	}

	public String getDependentName() {
		return dependentName;
	}

	public void setDependentName(String dependentName) {
		dependentName = dependentName;
	}

	public String getDependentRelation() {
		return dependentRelation;
	}

	public void setDependentRelation(String dependentRelation) {
		dependentRelation = dependentRelation;
	}

	public Date getDependentDob() {
		return dependentDob;
	}

	public void setDependentDob(Date dependentDob) {
		dependentDob = dependentDob;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

}
