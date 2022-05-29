package com.example.blogapp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blogapp.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByEmail(String email);

}
