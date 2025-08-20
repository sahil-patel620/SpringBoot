package com.sahil.prod_ready_features.prod_ready_features.services;

import com.sahil.prod_ready_features.prod_ready_features.dtos.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> getAllPosts();

    PostDto createNewPost(PostDto inputPost);

    PostDto getPostById(Long postId);
}
