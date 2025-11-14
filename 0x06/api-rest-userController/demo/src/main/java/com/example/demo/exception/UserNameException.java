package com.example.demo.exception;

public class UserNameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNameException() {};

	public UserNameException(String message) {
		super(message);
	}

	public UserNameException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public UserNameException(Throwable throwable) {
		super(throwable);
	}
}
