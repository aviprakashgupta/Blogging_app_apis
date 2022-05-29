package com.example.blogapp.Services;


import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.VoiceStatus;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.blogapp.Exceptions.*;
import com.example.blogapp.Dto.UserDto;
import com.example.blogapp.Entity.User;
import com.example.blogapp.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//getting all users
	public List<UserDto> getAllUser() {
		
		List<User> listUser = userRepository.findAll();
		
		List<UserDto> listUserDto= new ArrayList<>();
		for(int i =0 ;i<listUser.size();i++)
		{
			User currentUser = listUser.get(i);
			listUserDto.add(UserToDto(currentUser));
		}
		return listUserDto;
	}
	
	//getting one user 
	public UserDto getbyId(Integer uid)
	{
		User user = userRepository.findById(uid)
				.orElseThrow(()-> new UserNotFoundException("User" ,"id",uid));
		
		return UserToDto(user);
	}
	
	//post user 
	public UserDto saveUser(UserDto userDto)
	{
//		User user = DtoToUser(userDto);
//		User user2 = userRepository.save(user);
//		return UserToDto(user2);
		
		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		
		User user2 = userRepository.save(user);
		return UserToDto(user2);
		
	}
	
	public void deleteUser(Integer uid)
	{
		User user = userRepository.findById(uid)
				.orElseThrow(()-> new UserNotFoundException("User" ,"id",uid));
		
		userRepository.delete(user);
	}
	
	public UserDto updateUser(UserDto userDto , Integer uid)
	{
		
		User user = userRepository.findById(uid)
				.orElseThrow(()-> new UserNotFoundException("User" ,"id",uid));
		
		
		
		//user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		//user.setAbout(userDto.getAbout());
	   
		userRepository.save(user);
		
		return UserToDto(user);
	}
	
	public User DtoToUser(UserDto userDto)
	{
		User user = modelMapper.map(userDto, User.class);
//		user.setPassword(userDto.getPassword());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//	    user.setId(userDto.getId());
		return user;
	}
	
	public UserDto UserToDto(User user)
	{
		UserDto userDto = modelMapper.map(user, UserDto.class);
//		userDto.setPassword(user.getPassword());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setAbout(user.getAbout());
//		userDto.setId(user.getId());
		return userDto;
	}
	
}
