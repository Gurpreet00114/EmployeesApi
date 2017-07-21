package com.users.exception;

public class DefaultExceptionEmpApi extends Exception {

	/**
	 * This is the serial version id.
	 */
	private static final long serialVersionUID = 1L;

	private final int statusCode;

	public DefaultExceptionEmpApi(String message, Throwable cause, int statusCode) {
		super(message, cause);
		this.statusCode = statusCode;
	}

	public DefaultExceptionEmpApi(String message, int statusCode) {
		super(message);
		this.statusCode = statusCode;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
}
