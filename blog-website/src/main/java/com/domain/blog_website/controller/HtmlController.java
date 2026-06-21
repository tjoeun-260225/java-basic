package com.domain.blog_website.controller;

import com.domain.blog_website.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HtmlController {
    private final PostService postService;

    @GetMapping("/")
    //import org.springframework.ui.Model;
    public String mainPage(Model model) {
        model.addAttribute("posts",postService.모든게시물가져오기());
        return "index";
    }
}
