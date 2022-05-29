package com.example.blogapp.Controller;

import java.util.List;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogapp.Dto.ApiResponse;
import com.example.blogapp.Dto.PostDto;
import com.example.blogapp.Dto.PostResponse;
import com.example.blogapp.Services.PostService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "javainuseapi")
public class PostController {

	@Autowired
	private PostService postService;
	
	//create 
	@PostMapping("/user/{userId}/category/{catId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto ,
			@PathVariable Integer userId
			,@PathVariable Integer catId){
		
		PostDto postDto2 = postService.createPost(postDto, userId, catId);
		System.out.println(postDto2);
		
		return new ResponseEntity<PostDto>(postDto2 , HttpStatus.CREATED);
	}
	
	//get by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> findByUser(@PathVariable Integer userId)
	{
	   List<PostDto> list = postService.getPostByUserId(userId);
	   return new ResponseEntity<List<PostDto>>(list , HttpStatus.OK);
	}
	//get by category
	@GetMapping("/category/{catId}/posts")
	public ResponseEntity<List<PostDto>> findByCategory(@PathVariable Integer catId)
	{
	   List<PostDto> list = postService.getPostByCategoryId(catId);
	   return new ResponseEntity<List<PostDto>>(list , HttpStatus.OK);
	}
	
	//get all post 
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> findAllPosts(
			@RequestParam(value ="pageNumber" , defaultValue = "0" , required = false) Integer pageNumber,
			@RequestParam(value="pageSize" , defaultValue = "5" ,required = false) Integer pageSize,
			@RequestParam(value="sortBy" , defaultValue = "title",required = false) String sortBy ,
			@RequestParam(value="sortDir", defaultValue = "ASC" , required = false ) String sortDir)
	{
		PostResponse postResponse = postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
		return new ResponseEntity<PostResponse>(postResponse , HttpStatus.OK);
	}
	//get post by id
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> findPostById(@PathVariable Integer postId)
	{
		PostDto postDto = postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postDto ,HttpStatus.OK);
	}
	//detete by id
	
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<ApiResponse> deleteById(@PathVariable Integer postId)
	{
		postService.deletePostById(postId);
		ApiResponse apiResponse = new ApiResponse("post has been deleted" , "true");
		return new ResponseEntity<ApiResponse>(apiResponse , HttpStatus.OK);
	}
	
	// update by id
	
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updateById(@RequestBody PostDto postDto 
			, @PathVariable Integer postId){
		
		
	PostDto postDto2 = postService.updatePostById(postDto, postId);
	return new ResponseEntity<PostDto>(postDto2, HttpStatus.OK);
		
	}
	
	//search by title
	
	@GetMapping("/posts/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchByTitle(@PathVariable String keyword)
	{
		 List<PostDto> searchBykeyword = postService.searchBykeyword(keyword);
		 return new ResponseEntity<List<PostDto>>(searchBykeyword,HttpStatus.OK);
		 
	}
}
