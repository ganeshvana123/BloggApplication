package com.example.BlogApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BlogApplication.entity.comment;

public interface commentRepository  extends JpaRepository<comment, Long>{
    
    List<comment> getAllCommentsByPostId(Long id);
}
