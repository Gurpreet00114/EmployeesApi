package com.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity(name = "users")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	@Column
	private String ecode;
	@Column
	private String name;
	@Column
	private String email;

	private static final Logger logger = LoggerFactory.getLogger(Employee.class);
	
	public Employee() {
		super();
		logger.info("Employee object initialized..");
	}

	public Employee(String ecode, String name, String email) {
		super();
		this.ecode = ecode;
		this.name = name;
		this.email = email;
	}

	public String getEcode() {
		return ecode;
	}

	public void setEcode(String ecode) {
		this.ecode = ecode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", ecode=" + ecode + ", name=" + name + ", email=" + email + "]";
	}
	
	
	
}
