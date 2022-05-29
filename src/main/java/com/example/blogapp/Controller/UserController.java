package com.example.blogapp.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogapp.Dto.ApiResponse;
import com.example.blogapp.Dto.UserDto;
import com.example.blogapp.Entity.User;
import com.example.blogapp.Services.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/user")
@SecurityRequirement(name = "javainuseapi")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	//get all user
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser()
	{
          List<UserDto> listUserDtos = userService.getAllUser();
          return ResponseEntity.ok(listUserDtos);
	}
     
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId)
	{
		UserDto userDto  = userService.getbyId(userId);
		return ResponseEntity.ok(userDto);
	}
	
	//add user
	@PostMapping("/register")
	public ResponseEntity<ApiResponse> saveUserObj(@Valid @RequestBody UserDto userDto){
		UserDto user1 = userService.saveUser(userDto);
		ApiResponse response = new ApiResponse(String.format("user with id %s is created successfully", user1.getId()), "true");
		return new ResponseEntity<ApiResponse>(response, HttpStatus.CREATED);
		
	}
	
	//delete user
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Integer userId)
	{
		userService.deleteUser(userId);
		
	}
	
	//update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto , 
			@PathVariable Integer userId)
	{
		UserDto userDto2 = userService.updateUser(userDto, userId);
		return ResponseEntity.ok(userDto2);
	}
}

