package com.domain.blog_website.controller;

import com.domain.blog_website.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/signup")
    public String 회원가입페이지(){
        return "signup";
    }

    @PostMapping("/api/signup")
    public String 회원가입하기(){
        return "redirect:/";
    }

    @GetMapping("/members")
    public String 유저리스트(Model model){
        model.addAttribute("members", memberService.전체회원목록());
        return "members";
    }

}
