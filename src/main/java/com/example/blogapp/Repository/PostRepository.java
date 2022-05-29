package com.example.blogapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blogapp.Entity.Category;
import com.example.blogapp.Entity.Post;
import com.example.blogapp.Entity.User;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
	public List<Post> findByUser(User user);
	
	public List<Post> findByCategory(Category cat);
	
	public List<Post> findByTitleContaining(String Title);

}
