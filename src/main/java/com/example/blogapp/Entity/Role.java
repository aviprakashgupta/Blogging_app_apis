package com.example.blogapp.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<User> user;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Role(Integer id, String name, List<User> user) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public List<User> getUser() {
		return user;
	}



	public void setUser(List<User> user) {
		this.user = user;
	}

	
}
