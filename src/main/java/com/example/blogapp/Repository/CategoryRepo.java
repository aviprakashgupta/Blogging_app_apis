package com.example.blogapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blogapp.Entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
