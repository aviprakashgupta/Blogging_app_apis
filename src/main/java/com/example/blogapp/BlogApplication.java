package com.example.blogapp;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.blogapp.Entity.User;
import com.example.blogapp.Repository.UserRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "MircoBlogging App APIs" ,version = "1.0", description = "Application can be used to create Post , user can comment on the post , add new post in a category  , delete new post , add new comment etc , User can be register using regiser api , all the Get api are public but for other apis user needs to authenticate using BASIC AUTH "))
@SecurityScheme(name = "javainuseapi",scheme = "basic",type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class BlogApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		
		//List<User> user = userRepository.findByEmail("aman@g.com");
		
	}
}
