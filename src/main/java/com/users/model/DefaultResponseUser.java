package com.users.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.users.constants.ApplicationConstants;

public class DefaultResponseUser {

	private String message;
	private int statusCode;
	private List<Employee> data;

	public DefaultResponseUser(String message, int statusCode, List<Employee> data) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.data = data;
	}

	/*
	 * Default valued constructors.
	 */
	public static DefaultResponseUser getOKResponse(List<Employee> data) {
		return new DefaultResponseUser(ApplicationConstants.SUCCESSFULL_UPDATED, HttpStatus.OK.value(), data);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public List<Employee> getData() {
		return data;
	}

	public void setData(List<Employee> data) {
		this.data = data;
	}

}
