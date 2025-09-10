package com.homework.Week5HomeWork.services;

import com.homework.Week5HomeWork.dto.PostDto;
import com.homework.Week5HomeWork.entities.PostEntity;
import com.homework.Week5HomeWork.exceptions.ResourceNotFoundException;
import com.homework.Week5HomeWork.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;
    private  final ModelMapper modelMapper;


    public List<PostDto> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDto.class))
                .collect(Collectors.toList());
    }

    public PostDto getPostById(Long postId) {
        PostEntity postEntity = postRepository.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post not found with id : "+ postId));

        return modelMapper.map(postEntity, PostDto.class);
    }

    public PostDto createNewPost(PostDto inputPost) {
        PostEntity newPost = modelMapper.map(inputPost, PostEntity.class);
         PostEntity savedPost = postRepository.save(newPost);
        return modelMapper.map(savedPost , PostDto.class);
    }

    public Boolean deletePostById(Long postId) {
        PostEntity postEntity = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post not found with id : "+ postId));
        postRepository.deleteById(postId);
        return true;
    }

    public PostDto updatePost(Long postId, PostDto inputDto) {
        PostEntity olderPost = postRepository.findById(postId).
                orElseThrow(()-> new ResourceNotFoundException("Post not found with id: "+ inputDto));
        inputDto.setId(postId);
        modelMapper.map(inputDto, olderPost);
        PostEntity savedPost = postRepository.save(olderPost);
        return modelMapper.map(savedPost, PostDto.class);
    }
}
