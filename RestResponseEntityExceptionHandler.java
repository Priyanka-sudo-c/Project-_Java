package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorMessage> customerNotFound(CustomerNotFoundException exception, WebRequest request){
		ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		
	}
	
	@ExceptionHandler(RoomNotFoundException.class)
	public ResponseEntity<ErrorMessage> roomNotFound(RoomNotFoundException exception, WebRequest request){
		ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		
	}
	@ExceptionHandler(MenuNotFoundException.class)
	public ResponseEntity<ErrorMessage> menuNotFound(MenuNotFoundException exception, WebRequest request){
		ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		
	}
	
}
