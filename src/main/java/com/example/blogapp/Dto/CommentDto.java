package com.example.blogapp.Dto;

import com.example.blogapp.Entity.Post;
import com.example.blogapp.Entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CommentDto {
	
    private Integer id;
	
	private String content;
	
	@JsonIgnore
	private PostDto post;
	
	
	public CommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentDto(Integer id, String content, PostDto post) {
		super();
		this.id = id;
		this.content = content;
		this.post = post;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public PostDto getPost() {
		return post;
	}

	public void setPost(PostDto post) {
		this.post = post;
	}

	
	

}
