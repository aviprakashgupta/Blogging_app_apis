package com.example.blogapp.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.web.servlet.SecurityMarker;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogapp.Dto.ApiResponse;
import com.example.blogapp.Dto.CategoryDto;
import com.example.blogapp.Services.CategoryService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;

@RestController
@RequestMapping("/api/categories")
@SecurityRequirement(name = "javainuseapi")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto)
	{
		CategoryDto categoryDto2 = categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(categoryDto2 , HttpStatus.CREATED);
	}
	
	//delete
	
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> createCategory(@PathVariable Integer catId)
	{
	      categoryService.deleteCategory(catId);
	      ApiResponse apiResponse  = new ApiResponse("Category is deleted ", "true");
		return new ResponseEntity<ApiResponse>(apiResponse , HttpStatus.OK);
	}
	
	//update
	
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto
			, @PathVariable Integer catId)
	{
		CategoryDto categoryDto2 = categoryService.updateCategory(categoryDto,catId);
		return new ResponseEntity<CategoryDto>(categoryDto2 , HttpStatus.OK);
	}
	
	
	//get by id
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer catId)
	{
	      CategoryDto categoryDto = categoryService.getCategoryById(catId);
	   
		return new ResponseEntity<CategoryDto>(categoryDto , HttpStatus.OK);
	}
	
	
	//get all
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategoryById()
	{
	      List<CategoryDto> categoryDto = categoryService.getAllCategory();
	   
		return new ResponseEntity<List<CategoryDto>>(categoryDto , HttpStatus.OK);
	}

}
