package com.example.BlogApplication.service;

import java.util.List;

import com.example.BlogApplication.entity.post;

public interface postService {
    post savePost(post post);

    List<post> getAllPosts();

    post getPostById(Long id);

    void likePost(Long id);

    List<post> getPostsByName(String name);
}
