package com.example.blogapp.Dto;

import org.springframework.stereotype.Component;

@Component
public class ApiResponse {
  String message;
  String success;
  
  
  
public ApiResponse() {
	super();
	// TODO Auto-generated constructor stub
}

public ApiResponse(String message, String success) {
	super();
	this.message = message;
	this.success = success;
}

public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getSuccess() {
	return success;
}
public void setSuccess(String success) {
	this.success = success;
}
  
  
  
}
