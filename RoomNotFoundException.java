package com.example.demo.error;

public class RoomNotFoundException extends Exception{

	public RoomNotFoundException(String  message) {
		super(message);
	}
}
