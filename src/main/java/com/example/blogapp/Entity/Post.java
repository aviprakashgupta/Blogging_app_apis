package com.example.blogapp.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	
	private String title;
	
	private String image;
	
	private Date addedDate;
	
	@ManyToOne
	private User user;

	@ManyToOne
	private Category category;
	
	@OneToMany(mappedBy = "post" , cascade = CascadeType.ALL)
	private List<Comment> comment;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

   
	


	public Post(int postId, String title, String image, Date addedDate, User user, Category category,
			List<Comment> comment) {
		super();
		this.postId = postId;
		this.title = title;
		this.image = image;
		this.addedDate = addedDate;
		this.user = user;
		this.category = category;
		this.comment = comment;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
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
	
	

}
