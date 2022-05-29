package com.example.blogapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blogapp.Entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
