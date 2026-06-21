package com.domain.blog_website.service;

import com.domain.blog_website.model.entity.Post;
import com.domain.blog_website.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> 모든게시물가져오기(){
        return postRepository.findAll();
    }
}
