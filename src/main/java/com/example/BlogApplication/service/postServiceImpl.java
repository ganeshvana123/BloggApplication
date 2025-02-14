package com.example.BlogApplication.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlogApplication.entity.post;
import com.example.BlogApplication.repository.postRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class postServiceImpl implements postService{

    @Autowired
    private postRepository postRespository;

    public post savePost(post post){
        post.setLikeCount(0);
        post.setViewCount(0);
        post.setDate(new Date());
        return postRespository.save(post);
    }

    public List<post> getAllPosts(){
        return postRespository.findAll();
    }

    public post getPostById(Long id){
        Optional<post> post = postRespository.findById(id);
        if(post.isPresent()){
            post p = post.get();
            p.setViewCount(p.getViewCount()+1);
            return postRespository.save(p);
        }
        else{
            throw new EntityNotFoundException("The Post is not Found");
        }
    }

    public void likePost(Long id){
        Optional<post> post = postRespository.findById(id);
        if(post.isPresent()){
            post p = post.get();
            p.setLikeCount(p.getLikeCount()+1);
            postRespository.save(p);
        }
        else{
            throw new EntityNotFoundException("The Post is not Found");
        }
    }

    public List<post> getPostsByName(String name){
        return postRespository.findAllByNameContaining(name);
    }
}
