package com.homework.Week5HomeWork.controller;

import com.homework.Week5HomeWork.dto.PostDto;
import com.homework.Week5HomeWork.entities.PostEntity;
import com.homework.Week5HomeWork.exceptions.ResourceNotFoundException;
import com.homework.Week5HomeWork.repositories.PostRepository;
import com.homework.Week5HomeWork.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostDto> getaAllPosts(){
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

    @DeleteMapping(path = "/{postId}")
    public  Boolean deletePostById(@PathVariable Long postId){
        return postService.deletePostById(postId);
    }

    @PatchMapping(path = "/{postId}")
    public  PostDto updatePostById(@PathVariable Long postId, @RequestBody PostDto inputDto){
       return  postService.updatePost(postId,inputDto);
    }
}
