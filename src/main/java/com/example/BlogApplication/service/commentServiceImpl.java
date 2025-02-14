package com.example.BlogApplication.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlogApplication.entity.comment;
import com.example.BlogApplication.repository.commentRepository;
import com.example.BlogApplication.repository.postRepository;

import jakarta.persistence.EntityNotFoundException;

import com.example.BlogApplication.entity.post;
@Service
public class commentServiceImpl implements commentService {
    

    @Autowired
    private commentRepository commentRepository;
    @Autowired
    private postRepository postRepository;

    public comment createComment(Long id, String author, String content){
        Optional<post> post = postRepository.findById(id);
        if(post.isPresent()){
            comment comment = new comment();
            comment.setAuthor(author);
            comment.setContent(content);
            comment.setPost(post.get());
            comment.setDate(new Date());
            return commentRepository.save(comment);
        }
        throw new EntityNotFoundException("The post is not found");
    }

    public List<comment> getAllComments(Long id){
        return commentRepository.getAllCommentsByPostId(id);
    }
}
