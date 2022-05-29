package com.example.blogapp.Dto;




import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class UserDto {

	
	private int id;
	
//	@NotEmpty(message = "Should not be empty")
//	private String name;
	
	@Email(message = "should type email")
	private String email;
	
//	@NotEmpty(message = "Should not be empty")
//	private String about;
	
	@NotEmpty
	@Size(min=3,max=10,message = "Should be between 3 to 10 characters")
	private String password;
	
	List<CommentDto> listComments;
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	
	



	public UserDto(int id, @Email(message = "should type email") String email,
			@NotEmpty @Size(min = 3, max = 10, message = "Should be between 3 to 10 characters") String password,
			List<CommentDto> listComments) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.listComments = listComments;
	}









	public List<CommentDto> getListComments() {
		return listComments;
	}




	public void setListComments(List<CommentDto> listComments) {
		this.listComments = listComments;
	}




	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



//	public String getName() {
//		return name;
//	}
//
//
//
//	public void setName(String name) {
//		this.name = name;
//	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



//	public String getAbout() {
//		return about;
//	}
//
//
//
//	public void setAbout(String about) {
//		this.about = about;
//	}

	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}



//	@Override
//	public String toString() {
//		return "UserDto [id=" + id + ", name=" + name + ", email=" + email + ", about=" + about + ", password="
//				+ password + "]";
//	}

    
	
	

	
}
