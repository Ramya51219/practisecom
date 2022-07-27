package com.example.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmployeeAlreadyExistsException extends RuntimeException {

	private static String msg;
	public void EmployeAlreadyExistsException() {}
	public EmployeeAlreadyExistsException(String string) {
		// TODO Auto-generated constructor stub
		super(msg);
		this.msg=msg;
	}
	public String getMsg() {
		return "Employee Already present in database";
	}

}
