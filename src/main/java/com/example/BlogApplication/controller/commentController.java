package com.example.BlogApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlogApplication.service.commentService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@CrossOrigin("*")
@RequestMapping("/comments")
public class commentController {
    @Autowired
    private commentService commentService;

    @PostMapping("/createComment")
    public ResponseEntity<?> createComment(@RequestParam Long id, @RequestParam String author, @RequestParam String content){
        try{
            return ResponseEntity.ok(commentService.createComment(id, author, content));
        }
         catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }   
    
    @GetMapping("/getAllComments/{id}")
    public ResponseEntity<?> getAllComments(@PathVariable Long id){
        try{
            return ResponseEntity.ok(commentService.getAllComments(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
