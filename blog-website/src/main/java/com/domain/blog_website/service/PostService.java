package com.domain.blog_website.service;

import com.domain.blog_website.model.entity.Post;
import com.domain.blog_website.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/*
 @RequiredArgsConstructor
 - Lombok 에서 제공하는 어노테이션
   생성자를 자동으로 생성

     public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    를 Lombok 에서 제공하는
    @RequiredArgsConstructor
    로 대신 대체하여 사용할 수 있는 표기법
 */
@RequiredArgsConstructor
public class PostService {
    //private final PostRepository postRepository;
    // final = 상수 한 번 값을 할당하면 변경 불가능한 변수를 만드는 키워드
    // postRepository 현재 PostRepository에 내장되어 있는
    // 데이터 이외 다른 데이터를 현재 service에서 추가할 수 없는 상태
    // DB관련된 것을 PostRepository.java 에 코드를 기입해놓았고,
    // PostRepository 에 무언가를 추가하고 싶다면
    // PostRepository.java 에 가서 코드를 수정할 것!
    public final PostRepository postRepository ;

//    public PostService(PostRepository postRepository) {
//        this.postRepository = postRepository;
//    }

    public List<Post> 모든게시물가져오기(){
        return postRepository.findAll();
    }
}
