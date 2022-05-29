package com.example.blogapp.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="user_table")
public class User implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	private String email;
	
	private String password;
	
	
	@OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
	private List<Post> listPosts;


	@OneToMany(mappedBy = "user1" ,cascade = CascadeType.ALL)
    private List<Comment> listComments;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Role> listRoles;

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	





	public User(int id, String email, String password, List<Post> listPosts, List<Comment> listComments,
			List<Role> listRoles) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.listPosts = listPosts;
		this.listComments = listComments;
		this.listRoles = listRoles;
	}







	public List<Post> getListPosts() {
		return listPosts;
	}



	public void setListPosts(List<Post> listPosts) {
		this.listPosts = listPosts;
	}



	public List<Comment> getListComments() {
		return listComments;
	}



	public void setListComments(List<Comment> listComments) {
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
//	public void setAbout(String about) {
//		this.about = about;
//	}
	
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		int size = listRoles.size();
		List<GrantedAuthority> listAuthorities = new ArrayList<>();
		for(int i=0;i<size;i++)
		{
			GrantedAuthority authority = new SimpleGrantedAuthority(listRoles.get(i).getName());
			listAuthorities.add(authority);
		}
		return listAuthorities;
	}



	@Override
	public String getUsername() {
		return email;
	}



	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
	
	
}
