package com.domain.SpringCommunity.controller;

import com.domain.SpringCommunity.dto.Member;
import com.domain.SpringCommunity.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/*
@Controller 나 @RestController 의 경우
build.gradle 에서 starter 모듈이 있어야지 사용할 수 있는 어노테이션이다.

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter'
 */
@Controller
@RequiredArgsConstructor
public class HtmlController {
    // 반드시 @RequiredArgsConstructor 가 있어야지 사용할 수 있다.
    // @RequiredArgsConstructor = 상황에 따라 필요한 생성자 사용
    //  하는 객체 생성
    // 매번 Service를 호출할 때 마다 new MemberService()
    // 와 같은 형태를 개발자가 작성해야하는 번거로움 해소
    private final MemberService memberService;

    /*
    GetMapping 을 가져오는 경로는 아래 둘 중 하나에서 가져와 사용하게 된다.
    만약 build.gradle 에서 둘 중 하나의 모듈을 나의 프로젝트에 가져와
    세팅해주지 않는 다면 @GetMapping 과 같은 웹 접속 어노테이션을
    사용할 수 없다.
    외부에서 스프링부트 개발자가 spring-boot-starter-web 이라 하는
    모듈을 만들어서 제공하였고, 제공한 모듈을 인터넷이 연결되어 있는 상태로
    최초 1회 스프링부트 웹에서 나의 프로젝트로 다운로드 하여 코딩 작업을
    할 수 있는 상태가 되는 것

    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-webmvc'
     */
    @GetMapping("/")
    public String indexHtml() {
        return "index";
    }

    @GetMapping("/login")
    public String loginHtml() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupHtml() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(Member member) {
        memberService.회원가입기능(member);
        return "redirect:/login";
    }
}
