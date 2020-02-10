package com.example.demo.exception;

import java.sql.SQLException;

public class ExceptionHandling extends Exception {
	
	public ExceptionHandling(String message, Throwable t) {
		super(message,t);
	}
}
