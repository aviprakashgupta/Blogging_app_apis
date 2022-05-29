package com.example.blogapp.Services;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogapp.Dto.CategoryDto;
import com.example.blogapp.Entity.Category;
import com.example.blogapp.Exceptions.UserNotFoundException;
import com.example.blogapp.Repository.CategoryRepo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
    private ModelMapper modelMapper;
	
	//create 
	
	public CategoryDto createCategory(CategoryDto categoryDto)
	{
		Category category = modelMapper.map(categoryDto, Category.class);
		Category savedCategory = categoryRepo.save(category);
		
	   return modelMapper.map(savedCategory, CategoryDto.class);
	}
	
	//update
	
	public CategoryDto updateCategory(CategoryDto categoryDto , Integer catId)
	{
		Category category =categoryRepo.findById(catId)
				.orElseThrow(()-> new UserNotFoundException("category", "category Id", catId));
		
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		
		return modelMapper.map(category, CategoryDto.class);
		
		
	}
	
	//delete
	
	public void deleteCategory( Integer catId)
	{
		Category category =categoryRepo.findById(catId)
				.orElseThrow(()-> new UserNotFoundException("category", "category Id", catId));
		
		categoryRepo.delete(category);
	}
	
	//get by id
	
	public CategoryDto getCategoryById( Integer catId)
	{
		Category category =categoryRepo.findById(catId)
				.orElseThrow(()-> new UserNotFoundException("category", "category Id", catId));
		
		return modelMapper.map(category, CategoryDto.class);
	}
	
	//get all
	
	public List<CategoryDto> getAllCategory()
	{
		List<Category> categoryList = new ArrayList<>();
		categoryList = categoryRepo.findAll();
		List<CategoryDto> categoryDtos  = new ArrayList<>();
		for(int i=0;i<categoryList.size();i++)
		{
			categoryDtos.add(modelMapper.map(categoryList.get(i), CategoryDto.class));
		}
		return categoryDtos;
	}
	
	

}
