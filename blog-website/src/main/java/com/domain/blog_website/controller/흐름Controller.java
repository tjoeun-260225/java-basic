package com.domain.blog_website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
@Controller
- 특정경로로 접속하면 templates 하위에 존재하는
  .html 화면을 웹에서 보여주기

@RestController
- @Controller + @ResponseBody
  return 결과를 .html이 아니라
         특정 데이터를 JSON으로 자동 변환해서 사용
-> 오늘 오후나 다음주 쯤 들어갈 예정
 */
@Controller
public class 흐름Controller {

    @GetMapping("/testurl")
    public String 테스트페이지(Model model){

        model.addAttribute("data_1",
                "안녕하세요.");
        model.addAttribute("data_2",
                1);
        return "test";//test.html 에는
        // data_1 :"안녕하세요"
        // data_2 :1            변수이름:데이터 형태로 전달
    }
}
