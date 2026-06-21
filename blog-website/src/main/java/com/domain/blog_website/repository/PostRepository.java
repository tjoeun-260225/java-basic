package com.domain.blog_website.repository;

import com.domain.blog_website.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/*
JpaRepository - SpringBoot 에서 지향하는 SQL 세팅 방법으로
DB의 CRUD(create, read, update, delete) 작업을 직접 SQL로 작성하지않고,
쉽게 처리할 수 있게 해주는 도구
저장하기 전체조회 와 같은 기능들이 내장되어 있다.
<Entity 폴더에서 만든 class 파일 명칭, @ID로 설정되어 있는 변수의 자료형>
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
