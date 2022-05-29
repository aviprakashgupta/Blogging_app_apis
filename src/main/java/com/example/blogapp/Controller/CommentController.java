package com.example.blogapp.Controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogapp.Dto.CommentDto;
import com.example.blogapp.Services.CommentService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "javainuseapi")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
    //save a comment
	@PostMapping("/user/{userId}/posts/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(
			@PathVariable Integer postId,
			@PathVariable Integer userId,
			@RequestBody CommentDto commentDto)
	{
		      CommentDto createdComment = commentService.createComment(postId,userId, commentDto);
		      return new ResponseEntity<CommentDto>(createdComment,HttpStatus.CREATED);
	}
}
