package com.users.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.users.exception.DefaultExceptionEmpApi;
import com.users.model.DefaultResponseUser;
import com.users.model.Employee;
import com.users.service.EmpService;
import com.users.constants.ApplicationConstants;

@RestController
public class EmpController {

	@Autowired
	EmpService service;

	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	private static final String BASE_PATH = "employee/";

	@RequestMapping(value = "employees")
	public ResponseEntity<DefaultResponseUser> getEmployees() {
		List<Employee> employees = StreamSupport.stream(service.getEmployees().spliterator(), false)
				.collect(Collectors.toList());
		logger.info(ApplicationConstants.SUCCESSFULL_RETRIEVED);
		return new ResponseEntity<>(DefaultResponseUser.getOKResponse(employees), HttpStatus.OK);
	}

	@RequestMapping(value = BASE_PATH + "save")
	public ResponseEntity<DefaultResponseUser> saveEmployee(@RequestBody Employee emp) throws DefaultExceptionEmpApi {
		logger.info("Save request request received for employee:" + emp);
		if (emp.getEcode() == null || emp.getEcode().isEmpty()) {
			throw new DefaultExceptionEmpApi(ApplicationConstants.INSUFFICIENT_DATA, HttpStatus.BAD_REQUEST.value());
		}
		Employee employee = service.saveEmployee(emp);
		logger.info(ApplicationConstants.SUCCESSFULL_UPDATED);
		return new ResponseEntity<>(DefaultResponseUser.getOKResponse(Arrays.asList(employee)), HttpStatus.OK);
	}

	@RequestMapping(value = BASE_PATH + "delete")
	public ResponseEntity<DefaultResponseUser> deleteEmployee(@RequestBody Employee employee)
			throws DefaultExceptionEmpApi {
		logger.info("Delete request request received for employee-id:" + employee.getId());
		if (employee.getId() == null) {
			throw new DefaultExceptionEmpApi(ApplicationConstants.INSUFFICIENT_DATA, HttpStatus.BAD_REQUEST.value());
		}
		service.removeEmployee(employee);
		logger.info(ApplicationConstants.SUCCESSFULL_DELETED);
		return new ResponseEntity<>(DefaultResponseUser.getOKResponse(Arrays.asList(employee)), HttpStatus.OK);
	}

}
