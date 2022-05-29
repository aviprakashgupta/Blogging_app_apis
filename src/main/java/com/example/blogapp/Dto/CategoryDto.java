package com.example.blogapp.Dto;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
public class CategoryDto {
	
    private Integer id;
    
    @NotEmpty(message = "should not be empty")
	private String categoryTitle;
	
    @NotEmpty(message = "should not be empty")
	private String categoryDescription;

	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDto(Integer id, String categoryTitle, String categoryDescription) {
		super();
		this.id = id;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	

}
