package com.domain.blog_website.service;

import com.domain.blog_website.model.entity.Post;
import com.domain.blog_website.repository.설명Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/*
AI 야 springboot로 model view controller 나누어서
코드써 ^^

MVC 적합 하게 처음부터 주는 코드가 없다.

controller
-> 소비자가 특정 route / 경로로 접속했을 때
요청하는 요구사항을 반환하거나 처리에 따른 결과 전달

로그인 페이지에서 로그인 요청
/api/login
-> 어떤 기능
-> 결과를 담을 변수명칭에 서비스에서 전달한 결과를
    소비자에게 반환

service 에서 본격적인 비즈니스 코드 로직을
심화적으로 작성
 */
@Service // 실질적인 중요 코드 로직을 작성하며,
// util config repository에 작성해놓은
// 메서드를 가져와 상황에 따라 사용하는 공간
@RequiredArgsConstructor // 생성자를 직접 작성하지 않고 어노테이션으로 처리
// 추가적으로 가져와서 사용하는 util config repository 로직에서
// 기능을 추가하거나, 로그를 출력하여 상태확인이 필요할 경우
// 해당 .java 파일에서 작업할 것이라는게 기본 원칙
public class 설명Service {
    private final 설명Repository repository;


    public void 포스팅만들기기능(Post post) {
        // 소비자가 제목 본문을 모두 작성한게 맞는지 확인
        // 악성으로 잘못 만들어진 내용은 없는지 확인 로직 작성
        // 비밀번호를 작성했고, 비밀번호를 Repository에 저장하기 전에
        // 암호화 처리하는 작업
        // 소비자가 작성한 내용을 내용암호화 라는 공간에 임시 저장
        String 내용암호화 = post.getContent();
        String 암호화완성 = 암호화하는기능(내용암호화);
        post.setContent(암호화완성);
        // 내용을 암호화한 posting 제목과 내용을 db에 저장하는 작업
        repository.save(post);
    }

    public void 회원가입(String 이름, String 비밀번호, String 이메일, String 연락처){
        // 이메일이 중복인지 확인하고, 이메일 중복이면 회원가입 못하게 반환
        // 이메일 중복이 아니라면 인증번호 전송했는지 확인하고, 본인이 맞는지 확인이 안됐으면
        // 회원가입 반환

        // 연락처도 중복인지 확인하고, 연락처가 기입된 회원이라면
        // 이미 가입된 회원입니다. 로그인해주세요.
        // ejwhdms1234!
        // $2a$10$NIBYXqoudFI7TuBKCvCZxuNHJyM35G7lS4tkc

        // db에 저장을 하기 전에 비밀번호는 암호화 처리를 진행한다음 저장
    }
    public String 암호화하는기능(String 데이터) {return "암호화 처리 완료된 문자열";}
}

// controller -> 소비자가 요청하는 요구사항을
// 서비스에 전달하고 서비스에서 나온 결과를 전달하는 역할

// service   -> 전반적인 대부분의 소비자 요구사항을 처리하는 모든 로직 기재
