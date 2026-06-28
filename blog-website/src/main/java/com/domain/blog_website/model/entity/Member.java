package com.domain.blog_website.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "members")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Member {
    /*
    db 나 entity 에서 컬럼명칭은 최대한 상세히 작성

    snake_case  중간에 언더스코어(_)로 단어 구분
    camelCase  첫 단어 소문자 이후 대문자로 단어들 구분
    PascalCase 첫 단어 대문자 이후 시작하는 모든 첫 단어 대문자로 구분
    kebab-case 글자 사이에 하이튼(-)이 꼬치에 꽂힌 케밥처럼 보인다

    DB 에서 select 와 같은 예약어나 컬럼명칭 대소문자 구분 없기 때문에 _로 구분하여 단어를 구분

    SELECT * FROM POST;
    SELECT * from post;
    결과는 같다. 이유는 대소문자 구분을 그렇게까지 예약어나 테이블명칭에서 하지 않기 때문
    db의 경우 _로 컬럼명칭 내에 단어 구분

     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id; // id = 가입한 순서, 게시물을 작성한 순서
    // primary 키를 String 이나 Long 과 같이 객체형태로 작성하는 이유
    // https://brand.naver.com/쇼핑몰이름/products/000000000
    // 존재하지 않는 상품입니다. 페이지에 표기가 되는 이유는
    // 만약에 int 로 존재하지 않는 상품페이지를 받았을 경우
    // int long 과 같은 숫자타입은 null 값을 0으로 변환하여 사용
    // 000000000 존재하지 않는 상품번호가 맞는데 0번째 존재하는 상품으로 이동하게 된다.

    // 유저번호조회 -> 132414 번호는 존재하지 않는 가입되지않은 유저 번호
    //                 자동으로 0번 유저 조회가 되는 현상 발생할 수 있다.
//    private int member_id;

    private String member_username; // 아이디
    private String member_password; // 비밀번호
    private String member_email;
}
