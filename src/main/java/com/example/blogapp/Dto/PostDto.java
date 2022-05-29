package com.example.blogapp.Dto;

import java.util.Date;
import java.util.List;


public class PostDto {
	
     private int postId;
	
	private String title;
	
	private String image;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
	List<CommentDto> comments;

	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public PostDto(int postId, String title, String image, Date addedDate, CategoryDto category, UserDto user,
			List<CommentDto> comments) {
		super();
		this.postId = postId;
		this.title = title;
		this.image = image;
		this.addedDate = addedDate;
		this.category = category;
		this.user = user;
		this.comments = comments;
	}


	public List<CommentDto> getCommentList() {
		return comments;
	}



	public void setCommentList(List<CommentDto> commentList) {
		this.comments = commentList;
	}



	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PostDto [postId=" + postId + ", title=" + title + ", image=" + image + ", addedDate1=" + addedDate
				+ ", category=" + category + ", user=" + user + "]";
	}


}
