package com.example.blogapp.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogapp.Dto.CommentDto;
import com.example.blogapp.Dto.PostDto;
import com.example.blogapp.Dto.UserDto;
import com.example.blogapp.Entity.Comment;
import com.example.blogapp.Entity.Post;
import com.example.blogapp.Entity.User;
import com.example.blogapp.Exceptions.UserNotFoundException;
import com.example.blogapp.Repository.CommentRepository;
import com.example.blogapp.Repository.PostRepository;
import com.example.blogapp.Repository.UserRepository;

@Service
public class CommentService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CommentDto createComment(Integer postId, Integer userId, CommentDto commentDto)
	{
	   Post post = postRepository.findById(postId)
			   .orElseThrow(()-> new UserNotFoundException("Post", "post Id", postId));
	   
	   User user = userRepository.findById(userId)
			   .orElseThrow(()-> new UserNotFoundException("User", "user Id", userId));
	   
	   Comment comment = new Comment();
	   comment.setContent(commentDto.getContent());
	   comment.setPost(post);
	   comment.setUser1(user);
	  
	   commentRepository.save(comment);
	   
	  return modelMapper.map(comment, CommentDto.class);  
	  
	}
	
	
}
