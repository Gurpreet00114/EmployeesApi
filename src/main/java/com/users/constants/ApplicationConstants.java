package com.users.constants;

public class ApplicationConstants {
	/*
	 * Success messages.
	 */
	public static final String SUCCESSFULL_RETRIEVED = "Records are successfully fetched.";
	public static final String SUCCESSFULL_UPDATED = "Record is successfully updated.";
	public static final String SUCCESSFULL_DELETED = "Record is successfully deleted.";

	/*
	 * Error messages.
	 */
	public static final String INSUFFICIENT_DATA = "Data passed in request is In-Valid. Please verify !";
	public static final String ERROR_FAILURE_MESSAGE = "There was a problem in processing your request. Please try again later";

	/*
	 * To make sure no object creation for this class outside.
	 */
	private ApplicationConstants() {
	}
}
