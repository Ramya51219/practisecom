package com.example.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class EmployeeExceptionHandler {
	
	@ExceptionHandler(EmployeeAlreadyExistsException.class)
	public ResponseEntity<Object> EmployeeAlreadyExistsExceptionHandling(EmployeeAlreadyExistsException ex,WebRequest request){
		ApiError ed=new ApiError(new Date(), ex.getMsg(), request.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.NOT_FOUND);
		
	}
	public ResponseEntity<Object> globalExceptionHandling(Exception ex, WebRequest request){
		ApiError ed=new ApiError(new Date(), ((EmployeeAlreadyExistsException) ex).getMsg(), request.getDescription(false));
		return  new ResponseEntity<>(ed,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}

