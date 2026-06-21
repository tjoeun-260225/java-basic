// package = 자바 언어 차원의 개념
// 클래스들을 논리적으로 그룹화 하는 코드 단위
// 클래스가 어떤폴더에 위치하는지 주소 역할을 한다.
// 같은 이름의 클래스더라도 폴더 위치 경로가 다르면 다른 파일로 구분됨
// 맨 위에 이 클래스 파일은 어디에 위치한 파일임을 표기
package com.domain.blog_website.model.entity;
// entity = db 를 만들어주는 객체
// dto    = 프론트엔드 → 컨트롤러 → 백엔드 데이터 저장 전달 주고받는 통신에
//          데이터베이스 존재
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Post {
    @Id
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