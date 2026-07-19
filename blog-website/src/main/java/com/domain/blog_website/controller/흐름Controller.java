package com.domain.blog_website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
@Controller
- 특정경로로 접속하면 templates 하위에 존재하는
  .html 화면을 웹에서 보여주기

@RestController
- @Controller + @ResponseBody
  return 결과를 .html이 아니라
         특정 데이터를 JSON으로 자동 변환해서 사용
 */
@Controller
public class 흐름Controller {
    /*
    만약 @Controller 에서 특정 url api 만
    @RestController 형태로 사용하길 원하다면
    특정 @____Mapping 위 아래에 @ResponseBody 어노테이션을 추가해주면
    @RestController 와 같이 작동한다.
     */
    @ResponseBody
    @GetMapping("/testurl")
    public String 테스트페이지(Model model) {

        model.addAttribute("data_1",
                "안녕하세요.");
        model.addAttribute("data_2",
                1);
        return "test";//test.html 에는
        // data_1 :"안녕하세요"
        // data_2 :1            변수이름:데이터 형태로 전달
    }

    /*
     * 보통은
     * controller 를
     * html 화면 전용 컨트롤러와
     *
     * html 화면에 관계없이 데이터 전달, 저장, 수정, 삭제 등과 같은
     * 역할을 진행하는 컨트롤러가 존재
     * @RestController = @ResponseBody + @Controller 합쳐진 형태
     * 하나의 파일이름Controller.java 에는
     * @Controller 또는 @RestController 둘 중 하나만 존재해야 하며
     * 만약
     * @Controller 내에서 html 화면을 보는 것이 아닌
     * 데이터 전달이나 저장과 같은 역할에 대한 주소가 필요할 경우
     * 아래와 같이
     * @ResponseBody 을 사용하여 표기할 수 있다.
     *
     * @ResponseBody = html 파일이 아니라 해당 주소로 접속하면
     * 데이터 저장 / 데이터 조회 / 수정 / 삭제 와 같은
     * 역할을 위한 주소
     *
     * 보통은 백엔드 개발자와 프론트엔드 개발자가 나누어져 있을 때
     * 데이터를 주고받은 용도와 같이 많이 사용
     */
    // html 관련된 코드 XXX 작업하지 않고,
    // DB 와 같은 서버 관련 개발자는 아래와 같은 형태의 개발을 주로 사용
    @ResponseBody
    @GetMapping("/api/test")
    public String 테스트페이지_2() {
        return "어떻게 보이는지 확인합시다.";
    }
}
