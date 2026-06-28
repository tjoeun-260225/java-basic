package com.domain.blog_website.controller;

import com.domain.blog_website.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/*
모든 웹사이트에서는
컨트롤러에서 정해진 경로의 확장자 를 제공
 */
@Controller
@RequiredArgsConstructor
public class HtmlController {
    private final PostService postService;

    @GetMapping("/")
    public String mainPage(Model model) {
        /*
        import org.springframework.ui.Model;
        - Spring 이 만든 Model 을 가져와서 사용한다.
        - springframework에서 html ui에서 사용할 기능중 하나인 Model.java 가져온다.

        public String mainPage(Model model) {}
        SpringMVC 가 mainPage() 기능을 실행할 때
        Model 객체를 자동으로 만들어서 사용
        Model model = new Model(); 과 같이 사용했다면
        스프링에서는 () 안에 Model model 과 같이 작성하면
        위와 같은 형태를 알아서 생성해서 사용
        Model model = new Model();      === (Model model) 동일

        Model model 스프링에서 만든 Model.java 를 model 명칭으로 사용
        Model
        - Controller 에서 View(jsp or Thymeleaf)로 데이터를 전달하는 바구니
        - Controller 는 자바 세계, View 는 HTML 세계인데 그 사이에
          데이터를 전달해주는 역할

        index.html 화면을 / 여기서 보여주기 전에
        어떤 데이터를 담아서 index.html 화면에 보여줄 것인지 세팅
        화면에.속성추가하기("html에서 사용할 변수 이름", 변수이름에 담아둘 데이터
        model.addAttribute("posts",postService.모든게시물가져오기());
         */
        model.addAttribute("posts",postService.모든게시물가져오기());
        return "index";
        // return "index" 소비자가 https://www.도메인.com/ 로 접속했을 때
        // src/main/resources/templates/index.html 로 존재하는 파일 보여주기
        // springboot 에는 암묵적으로
        // templates/ 폴더 안에 존재하는 .html 확장자 페이지를
        // / routes 화면에 띄우겠다 라는 규칙이 내장되어 있다.
    }
}
