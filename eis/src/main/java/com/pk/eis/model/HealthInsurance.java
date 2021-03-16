package com.pk.eis.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "healthInsurance")
public class HealthInsurance implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int insuranceId;
	@Column
	private String insuranceName;
	@Column
	private String insuranceMailId;
	@Column
	@OneToMany(mappedBy="healthInsurance",fetch = FetchType.LAZY)
	private  List<Employee> empList;
	
	public int getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}
	public String getInsuranceName() {
		return insuranceName;
	}
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	public String getInsuranceMailId() {
		return insuranceMailId;
	}
	public void setInsuranceMailId(String insuranceMailId) {
		this.insuranceMailId = insuranceMailId;
	}
	public List<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	
}
