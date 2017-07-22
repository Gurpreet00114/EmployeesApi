package com.users.service;

import com.users.model.Employee;

public interface EmpService {
	Iterable<Employee> getEmployees();
	Employee saveEmployee(Employee emp);
	void removeEmployee(Employee emp);
}
