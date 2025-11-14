package com.example.demo.exception;

public class CPFException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CPFException() {};

	public CPFException(String message) {
		super(message);
	}

	public CPFException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public CPFException(Throwable throwable) {
		super(throwable);
	}
}
