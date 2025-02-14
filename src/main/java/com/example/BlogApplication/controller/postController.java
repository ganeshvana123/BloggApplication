package com.example.BlogApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlogApplication.entity.post;
import com.example.BlogApplication.service.postService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@CrossOrigin("*")
@RequestMapping("/posts")
public class postController {
    @Autowired
    private postService postService;
    @PostMapping("/createPost")
    public ResponseEntity<?> createPost(@RequestBody post post){
        try{
            return ResponseEntity.ok(postService.savePost(post));
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }


    @GetMapping("/getAllPosts")
    public ResponseEntity<?> getAllPosts() {
        try{
            return ResponseEntity.ok(postService.getAllPosts());
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }
    

    @GetMapping("/getPostById/{id}")
    public ResponseEntity<?> getPostById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(postService.getPostById(id));
        }
        catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/likePost/{id}")
    public ResponseEntity<?> likePost(@PathVariable Long id){
        try{
            postService.likePost(id);
            return ResponseEntity.ok("Post Liked Successfully");
        }
        catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @GetMapping("/getPostsByName/{name}")
    public ResponseEntity<?> getPostsByName(@PathVariable String name){
        try{
            return ResponseEntity.ok(postService.getPostsByName(name));
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }
}
