package com.example.blogapp.Exceptions;

import java.awt.ContainerOrderFocusTraversalPolicy;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.blogapp.Dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ApiResponse> ResourceNotFoundExceptionHandler(UserNotFoundException e)
	{
		String message = e.getMessage();
		ApiResponse response = new ApiResponse();
		response.setMessage(message);
		response.setSuccess("false");
		
		return new ResponseEntity<ApiResponse>(response , HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e)
	{
		Map<String, String> res = new HashMap<>();
		
	    e.getBindingResult().getAllErrors().forEach((error)->{
	    	String fieldName =  ((FieldError) error).getField();
	    	String defaultMessage = error.getDefaultMessage();
	    	
	    	res.put(fieldName, defaultMessage);
	    });
        	    
	    return new ResponseEntity<Map<String,String>>(res , HttpStatus.BAD_REQUEST);
	}

}
