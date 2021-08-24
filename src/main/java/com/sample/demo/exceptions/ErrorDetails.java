package com.sample.demo.exceptions;

import java.util.Date;

/**
 * Data Fields are added related to custom Exceptions ,message,timeStamp and
 * details will be set and get from here
 * 
 * @author Vidya sagar
 */
public class ErrorDetails {

	private String timeStamp;
	private String message;
	private String details;

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	// Constructor with arguments
	public ErrorDetails(String timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	// Constructor without arguments
	public ErrorDetails() {

	}

}
