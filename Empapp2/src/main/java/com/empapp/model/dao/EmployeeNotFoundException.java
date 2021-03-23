package com.empapp.model.dao;

public class EmployeeNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -9015120434992369254L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}
}