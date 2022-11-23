package com.graphql.learn.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.graphql.learn.utils.ApiResponse;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public ApiResponse studentNotFoundException(StudentNotFoundException ex) {
		String message = ex.getMessage();
		GraphQLError error = GraphqlErrorBuilder.newError().message(ex.getMessage()).build();
		log.info("error message :: " + error.toString());
		return new ApiResponse(message, false);
	}
}
