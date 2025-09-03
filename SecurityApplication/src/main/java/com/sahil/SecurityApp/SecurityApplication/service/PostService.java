package com.sahil.SecurityApp.SecurityApplication.service;



import com.sahil.SecurityApp.SecurityApplication.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> getAllPosts();

    PostDto createNewPost(PostDto inputPost);

    PostDto getPostById(Long postId);

    PostDto updatePost(PostDto inputPost, Long postId);
}
