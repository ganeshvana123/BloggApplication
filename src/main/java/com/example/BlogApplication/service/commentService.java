package com.example.BlogApplication.service;

import java.util.List;

import com.example.BlogApplication.entity.comment;

public interface commentService {
     comment createComment(Long id, String author, String content);

     List<comment> getAllComments(Long id);
}
