package com.home.projectboard.controller;

import com.home.projectboard.domain.Article;
import com.home.projectboard.domain.ArticleComments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


/*
* /articles    (완료)
* /articles/{id}
* /articles/search
* /articles/search-hashtag
* */
@RequestMapping("/articles")
@Controller()
public class ArticleController {

    private final static Logger logger = LoggerFactory.getLogger(ArticleController.class);
    @GetMapping()
    public String articles(ModelMap map){
        logger.debug("articles get method!!");
        map.addAttribute("articles", List.of());
        return "/articles/index";
    }
    @GetMapping("/{articleId}")
    public String article(@PathVariable long articleId, ModelMap map){
        logger.debug("article get method by id {}!!",articleId);


        Article article = Article.of("첫번째","나나나나","#java",null);
        ArticleComments a1 = ArticleComments.of("11",article);

        List<ArticleComments> articleCommentsList = new ArrayList<>();

        map.addAttribute("article", article);
        map.addAttribute("articleComments", articleCommentsList);
        return "/articles/detail";
    }
}
