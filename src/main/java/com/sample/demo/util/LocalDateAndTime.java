package com.sample.demo.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Details of the date and time releated methods will be there in class
 * LocalDateAndTime
 * 
 * @author Vidya sagar
 */
public class LocalDateAndTime {

	/**
	 * Returns Local date and time in this method
	 * 
	 * @return - local date and time will be returned in the format of dd-MM-yyyy
	 *         HH:mm
	 */
	public String getLocalDateTime() {

		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		String formatDateTime = dateTime.format(formatter);

		return formatDateTime;
	}

}
