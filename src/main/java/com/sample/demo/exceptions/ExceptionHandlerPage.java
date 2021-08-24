package com.sample.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.sample.demo.util.LocalDateAndTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * All sort of Exceptions and errors will be handled in this class ExceptionHandlerPage
 * 
 * @author Vidya sagar
 */
@ControllerAdvice
public class ExceptionHandlerPage {

	/**
	 * Returns Custom Exception Details Along with the status when a record is not found
	 * 
	 * @param exception - message related to exception
	 * @param request - url details will be send here
	 * @return - custom exception details along with status NOT_FOUND
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> toHandleResourceNotFound(ResourceNotFoundException exception, WebRequest request) {
		ErrorDetails error = new ErrorDetails(new LocalDateAndTime().getLocalDateTime(), exception.getMessage(),
				request.getDescription(false));

		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	}

	/**
	 * Returns Custom Exception Details Along with the status ,related to all custom exceptions
	 * 
	 * @param exception - message related to exception
	 * @param request - url details will be send here
	 * @return - custom exception details along with status INTERNAL_SERVER_ERROR
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> toHandleAll(Exception exception, WebRequest request) {
		ErrorDetails error = new ErrorDetails(new LocalDateAndTime().getLocalDateTime(), exception.getMessage(),
				request.getDescription(false));

		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Returns Custom Validation Details Along with the status 
	 * 
	 * @param exception - message related to Validation
	 * @return - custom exception details along with status BAD_REQUEST
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> toHandleAllCustomValidations(MethodArgumentNotValidException exception) {
		ErrorDetails error = new ErrorDetails(new LocalDateAndTime().getLocalDateTime(), "Its a validation error",
				exception.getBindingResult().getFieldError().getField() + "--"
						+ exception.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}

}
