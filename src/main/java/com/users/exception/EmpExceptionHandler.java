package com.users.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.users.constants.ApplicationConstants;
import com.users.model.DefaultResponseUser;

@ControllerAdvice
public class EmpExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(EmpExceptionHandler.class);

	@ExceptionHandler(DefaultExceptionEmpApi.class)
	public ResponseEntity<DefaultResponseUser> handleDefaultException(DefaultExceptionEmpApi exception) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		logger.error(exception.getMessage());
		return new ResponseEntity<>(new DefaultResponseUser(exception.getMessage(), exception.getStatusCode(), null),
				status);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<DefaultResponseUser> handleException(Exception e) {
		logger.error(e.getMessage());
		return new ResponseEntity<>(new DefaultResponseUser(ApplicationConstants.ERROR_FAILURE_MESSAGE,
				HttpStatus.INTERNAL_SERVER_ERROR.value(), null), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
