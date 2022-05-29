package com.example.blogapp.Dto;

import java.util.List;

public class PostResponse {
	
	private List<PostDto> content;
	private Integer pageNumber;
	private Integer pageSize;
	private Long totalElements;
	private Integer totalPages;
	private boolean islast;
	public PostResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostResponse(List<PostDto> content, Integer pageNumber, Integer pageSize, Long totalElements,
			Integer totalPages, boolean islast) {
		super();
		this.content = content;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.islast = islast;
	}
	public List<PostDto> getContent() {
		return content;
	}
	public void setContent(List<PostDto> content) {
		this.content = content;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public boolean isIslast() {
		return islast;
	}
	public void setIslast(boolean islast) {
		this.islast = islast;
	}
	
	
	

}
