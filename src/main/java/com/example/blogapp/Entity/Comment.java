package com.example.blogapp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String content;
	
	@ManyToOne
	private Post post;
	
	@ManyToOne
	private User user1;
	
	

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	

	public Comment(Integer id, String content, Post post, User user1) {
		super();
		this.id = id;
		this.content = content;
		this.post = post;
		this.user1 = user1;
	}






	public User getUser1() {
		return user1;
	}



	public void setUser1(User user1) {
		this.user1 = user1;
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

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	
	
}
