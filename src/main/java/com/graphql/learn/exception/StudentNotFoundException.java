package com.graphql.learn.exception;

public class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6464373420440456687L;

	public StudentNotFoundException(String message) {
		super(message);
	}
}
