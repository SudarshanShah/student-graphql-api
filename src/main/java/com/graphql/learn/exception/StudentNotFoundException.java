package com.graphql.learn.exception;

import java.io.Serial;

public class StudentNotFoundException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = -6464373420440456687L;

	public StudentNotFoundException(String message) {
		super(message);
	}
}
