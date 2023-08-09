package com.wileyedge.userrest.exceptions;

public class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException(String msg) {
		super(msg);
	}
}
