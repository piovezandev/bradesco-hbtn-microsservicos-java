package com.example.demo.exception;

public class UserIdException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserIdException() {};

	public UserIdException(String message) {
		super(message);
	}

	public UserIdException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public UserIdException(Throwable throwable) {
		super(throwable);
	}
}
