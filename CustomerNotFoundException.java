package com.example.demo.error;

public class CustomerNotFoundException extends Exception{

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
