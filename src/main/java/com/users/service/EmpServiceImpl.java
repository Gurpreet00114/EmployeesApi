package com.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.users.model.Employee;
import com.users.repositories.EmpDao;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	EmpDao dao;
	
	@Override
	public Iterable<Employee> getEmployees() {
		return dao.findAll();
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return dao.save(employee);
	}
	
	@Override
	public void removeEmployee(Employee employee) {
		dao.delete(employee);
	}
	
}
