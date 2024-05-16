package com.example.blog.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.blog.dto.ArticleListViewResponse;
import com.example.blog.service.BlogService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller

public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model){
        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles); // 블로그 글 저장 

        return "articleList"; // articleList.html 조회 
    }
}
