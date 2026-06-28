package com.domain.blog_website.repository;

import com.domain.blog_website.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface 설명Repository extends JpaRepository<Post, Long> {
    /*
    Springboot JPA 에서 제공하는 인터페이스
    기본적인 CRUD 및 페이징 정렬기능을 자동으로 제공
    C = create 생성
    R = read   만들다
    U = update 수정
    D = delete 삭제

    JpaRepository<entity 자바 클래스 명칭 , primary key 타입>

    설명Repository.java 안에서 개발자가 작성하지 않아도
    service에서 사용할 수 있도록 JpaRepository 에 내장되어 있는
    기본 기능들

    save(entity.java)  저장/수정 기능 (id 가 존재하면 update)
    INSERT INTO entity.java VALUES()

    findAll()          전체 조회
    SELECT * from entity.java

    findById(id)       단건 조회 Optional<T> 반환
    deleteById(id)     id로 삭제
    와 같은 기본 제공 메서드가 굉장히 많이 존재

    이외 추가적으로 작성하고자 하는 메서드는 기본형태를 수정해서 사용
     */
    List<Post> findByTitle(String title);
    // SELECT * FROM posts WHERE title = ?  ;
    // 형태의 SQL 문이 findBy where 로 찾을 컬럼이름;
    // 완성된다.
//    @Query("SELECT * FROM posts")
//    List<Post> 내가만든기능();
}

// 폴더만들고.. sql 작성하는게 너무 힘들다..
// sql에 크게 신경쓰지 않고 빠르게 프로젝트를 만들고 싶다.
// JPA 추천

// sql 부터 하나하나 내가 따져가면서 세부적으로 프로젝트를 만들고 싶다.
// 까다롭게 직접 하는 것을 선호한다.
// myBatis 추천
