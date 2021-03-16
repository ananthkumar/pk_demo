package com.pk.eis.vo;

import java.text.SimpleDateFormat;

import com.pk.eis.model.Employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	private String name;
	private String designation;
	private String doj;
	private String email;
	private String location;
	private String phoneNum;
	
	public User(String name, String designation, String doj, String email, String location, String phoneNum){
		this.name = name;
		this.designation = designation;
		this.doj = doj;
		this.email = email;
		this.location = location;
		this.phoneNum = phoneNum;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Employee getEmployee(User user){
		Employee emp = new Employee();
		emp.setDesignation(user.getDesignation());
		java.sql.Date sqlDate = null;
		try {
		    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	        java.util.Date utilDate = format.parse(user.getDoj());
	        sqlDate = new java.sql.Date(utilDate.getTime());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		emp.setDoj(sqlDate);
		emp.setEmail(user.getEmail());
		emp.setLocation(user.getLocation());
		emp.setName(user.getName());
		emp.setPhoneNum(user.getPhoneNum());
		return emp;
	}
	
	public User getDummyUser() {
		User user = new User();
		user.setDesignation("SOFTWARE ENGINEER");
		user.setDoj("1986-02-02");
		user.setEmail("sananth949494@gmail.com");
		user.setLocation("hyderabad");
		user.setName("ananth1");
		user.setPhoneNum("123456789");
		return user;
	}
	
}
