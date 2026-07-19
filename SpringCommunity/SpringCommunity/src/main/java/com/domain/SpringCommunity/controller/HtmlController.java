package com.domain.SpringCommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
@Controller 나 @RestController 의 경우
build.gradle 에서 starter 모듈이 있어야지 사용할 수 있는 어노테이션이다.

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter'
 */
@Controller
public class HtmlController {

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
}
