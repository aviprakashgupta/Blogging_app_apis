package com.example.blogapp.Services;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.blogapp.Dto.PostDto;
import com.example.blogapp.Dto.PostResponse;
import com.example.blogapp.Entity.Category;
import com.example.blogapp.Entity.Post;
import com.example.blogapp.Entity.User;
import com.example.blogapp.Exceptions.UserNotFoundException;
import com.example.blogapp.Repository.CategoryRepo;
import com.example.blogapp.Repository.PostRepository;
import com.example.blogapp.Repository.UserRepository;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import net.bytebuddy.asm.Advice.Return;


@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
    private UserRepository userRepository;
    
	@Autowired
    private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// create 
	public PostDto createPost(PostDto postDto , Integer userId, Integer catId) {
		
		User user = userRepository.findById(userId)
				.orElseThrow(()-> new UserNotFoundException("User", "user Id", userId));
		
		Category category = categoryRepo.findById(catId)
				.orElseThrow(()-> new UserNotFoundException("Category", "category Id", catId));
		
		
		
		Post post = modelMapper.map(postDto, Post.class);
		post.setImage("default.image");
		post.setAddedDate(new Date());
		post.setTitle(postDto.getTitle());
	    post.setCategory(category);
	    post.setUser(user);
	    
	    Post savePost =  postRepository.save(post);
	    System.out.println(savePost.getCategory().getCategoryTitle());
	    return modelMapper.map(savePost , PostDto.class);
		
	}
	
	
	//get post by user id
	public List<PostDto> getPostByUserId(Integer userId)
	{
		
		User user = userRepository.findById(userId)
				.orElseThrow(()->new UserNotFoundException("User","User Id", userId));
		
		List<Post> listPosts = new ArrayList<>();
		List<PostDto> listPostDtos = new ArrayList<>();
		
		listPosts = postRepository.findByUser(user);
		for(int i=0;i<listPosts.size();i++)
		{
			listPostDtos.add(modelMapper.map(listPosts.get(i), PostDto.class));
		}
		
		return listPostDtos;
	}
	
	public List<PostDto> getPostByCategoryId(Integer catId)
	{
		
		Category category = categoryRepo.findById(catId)
				.orElseThrow(()->new UserNotFoundException("Category","Category Id", catId));
		
		List<Post> listPosts = new ArrayList<>();
		List<PostDto> listPostDtos = new ArrayList<>();
		
		listPosts = postRepository.findByCategory(category);
		for(int i=0;i<listPosts.size();i++)
		{
			listPostDtos.add(modelMapper.map(listPosts.get(i), PostDto.class));
		}
		
		return listPostDtos;
	}
	
	//get all post
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize , String sortBy, String sortDir){
		
	    Sort sort = (sortDir.equalsIgnoreCase("asc"))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        
		 PageRequest page = PageRequest.of(pageNumber, pageSize,sort);
		 Page<Post> pagelist  = postRepository.findAll(page);
		 	
		List<Post> listPost = new ArrayList<>();
		List<PostDto> listPostDtos = new ArrayList<>();
		listPost = pagelist.getContent();
		
		for(int i=0;i<listPost.size();i++)
		{
			listPostDtos.add(modelMapper.map(listPost.get(i), PostDto.class));
		}
		PostResponse postResponse = new PostResponse();
		
		postResponse.setContent(listPostDtos);
		postResponse.setPageNumber(pagelist.getNumber());
		postResponse.setPageSize(pagelist.getSize());
		postResponse.setTotalElements(pagelist.getTotalElements());
		postResponse.setTotalPages(pagelist.getTotalPages());
		postResponse.setIslast(pagelist.isLast());
		
		return postResponse;
		
	}
	
	//get post by id
	public PostDto getPostById(Integer postId) {
		
		Post post = postRepository.findById(postId)
				.orElseThrow(()-> new UserNotFoundException("Post", "post Id", postId));
		
		return modelMapper.map(post, PostDto.class);
	}
	
	//detete a post
	
	public void deletePostById(Integer postId)
	{
		Post post = postRepository.findById(postId)
				.orElseThrow(()->new UserNotFoundException("Post", "Post Id", postId));
		 postRepository.delete(post);
	}
	
	//update a post 
	
	public PostDto updatePostById(PostDto postDto , Integer postId)
	{
		
		Post post = postRepository.findById(postId)
				.orElseThrow(()-> new UserNotFoundException("Post ", "Post Id", postId));
		
		post.setTitle(postDto.getTitle());
		post.setImage(postDto.getImage());
		post.setCategory(modelMapper.map(postDto.getCategory(),Category.class));
		post.setImage(postDto.getImage());
		post.setUser(modelMapper.map(postDto.getUser(), User.class));
		
		
	  Post post2 = postRepository.save(post);
  	  
	  return modelMapper.map(post2, PostDto.class);  
 
	}
	
	public List<PostDto> searchBykeyword(String keyword)
	{
		List<Post> findByTitleContaining = postRepository.findByTitleContaining(keyword);
		List<PostDto> postDtos = new ArrayList<>();
		
		for(int i=0;i<findByTitleContaining.size();i++)
		{
			postDtos.add(modelMapper.map(findByTitleContaining.get(i), PostDto.class));
	    }
          return postDtos;
	}
}
