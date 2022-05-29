package com.example.blogapp.Exceptions;

public class UserNotFoundException extends RuntimeException{
	
	public String message;
	public String cause;
	public Integer id;
	public UserNotFoundException(String message, String cause, Integer uid) {
		super(String.format("%s , not found ,%s not exist value %s",message,cause,uid ));
		this.message = message;
		this.cause = cause;
		this.id = uid;
	}
	
	
	

}
