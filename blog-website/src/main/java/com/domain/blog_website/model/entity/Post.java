// package = 자바 언어 차원의 개념
// 클래스들을 논리적으로 그룹화 하는 코드 단위
// 클래스가 어떤폴더에 위치하는지 주소 역할을 한다.
// 같은 이름의 클래스더라도 폴더 위치 경로가 다르면 다른 파일로 구분됨
// 맨 위에 이 클래스 파일은 어디에 위치한 파일임을 표기
package com.domain.blog_website.model.entity;
// entity = db 를 만들어주는 객체
// dto    = 프론트엔드 → 컨트롤러 → 백엔드 데이터 저장 전달 주고받는 통신에
//          데이터베이스 존재
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
가져오다 lombok 이라는 라이브러리에서 위 방법은 특정도구들을 하나하나 가져오겠다 표기법
lombok 이라는 라이브러리에 존재하는 모든 도구들을 가져와서 현재 .java 파일에서 사용하겠다.
import lombok.*;
 */
import lombok.*;
@Entity
// DataJpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration: Not a managed type: class com.domain.blog_website.model.entity.Post
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
/*
import jakarta.persistence
-> javax 심하게 오래된 버전의 AI 모델이므로, GPT AI 모델 변경 요청을 하거나..
   당분간 그 사이트 이용하지 말기.
    javax → jakarta
    jakarta.persistence
    java 에서 DB를 다루기 위해 만든 JPA 표준 규칙 모음
    JPA (Java Persistence API)
    = Java 에서 DB를 객체로 다루는 표준 방법

    javax = springboot 3 아래 버전은 모두 javax 가 맞으나, 현재 만약에 스프링부트를 공부하고 싶다.
    스프링을 공부하고 싶다 라면 3버전 이상을 공부할 것이고, 이럴 때는 jakarta 가 맞다.
    하지만 회사에서 springboot 1~2 버전을 사용한다면 javax가 맞다.
    실제 구현 Hibernate 가 담당

import jakarta.persistence.Table;

@Audited.Table(name="posts")
 */
@Table(name="posts") // DataBase를 생성할 때 table 명칭을 posts로 만들수 있다.
// 데이터베이스에서 table명칭의 경우 복수
// java 에서 객체를 생성할 때 작성하는 class 파일명칭 단수
// 데이터베이스는 데이터를 1개 이상 담고 있기 때문
// java 의 경우 각 데이터별로 객체를 한 번씩 사용하기 때문에 단수
public class Post {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
// 만약 위에
// @Getter @Setter @AllArgsConstructor @NoArgsConstructor 이 구문을 작성할 수 있는
// lombok 이 없으면 /**/ 에 있는 코드를 매번 개발자가 직접 작성해야 한다.
// 참고로 @Getter 가 있으면 public 으로 작성된 getter 는 사용할 수 없다.
// @이나 아래 코드 중 하나만 존재
/*
    public Post() {
    }

    public Post(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }

 */
}

// entity = 폴더에 존재하는 객체 파일의 경우
// create table 을 위한 용도로 자바에서 테이블 생성부터 도메인설정까지 모두다 할 수 있다.