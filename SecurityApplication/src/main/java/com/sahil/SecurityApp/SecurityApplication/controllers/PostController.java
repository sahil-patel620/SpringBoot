package com.sahil.SecurityApp.SecurityApplication.controllers;

import com.sahil.SecurityApp.SecurityApplication.dto.PostDto;
import com.sahil.SecurityApp.SecurityApplication.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {

    private  final PostService postService;

    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping(path = "/{postId}")
    public PostDto getPostById(@PathVariable Long postId){
        return postService.getPostById(postId);
    }

    @PostMapping
    public PostDto createNewPost(@RequestBody PostDto inputPost){
        return postService.createNewPost(inputPost);
    }

    @PutMapping(path = "/{postId}")
    public PostDto updatePost(@RequestBody PostDto inputPost, @PathVariable Long postId){
        return postService.updatePost(inputPost, postId);
    }

}
