package com.home.projectboard.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("Article Controller TEST")
@WebMvcTest(ArticleController.class)
class ArticleControllerTest {

    private final MockMvc mock;

    public ArticleControllerTest(@Autowired MockMvc mock) {
        this.mock = mock;
    }


    @DisplayName("[VIEW][GET] 게시글 전체 조회하는 뷰를 GET METHOD TEST")
    @Test()
    public void givenNothing_whenRequestArticles_thenResponseArticlesView() throws Exception {
        // given

        // when
        mock.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("/articles/index"))
                .andExpect(model().attributeExists("articles"));

        // then
    }
    @Disabled("구현 중")
    @DisplayName("[VIEW][GET] 특정 ID의 게시글을 조회하는 뷰를 GET METHOD TEST")
    @Test()
    public void givenId_whenRequestArticleById_thenResponseArticleView() throws Exception {
        // given

        // when
        mock.perform(get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(view().name("/articles/detail"))
                .andExpect(model().attributeExists("article"))
                .andExpect(model().attributeExists("articleComments"));

        // then
    }
    @Disabled("구현 중")
    @DisplayName("[VIEW][GET] 검색한 게시글을 조회하는 뷰를 GET METHOD TEST")
    @Test()
    public void givenSearchValue_whenRequestArticlesBySearch_thenResponseArticlesView() throws Exception {
        // given

        // when
        mock.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("search"));

        // then
    }
    @Disabled("구현 중")
    @DisplayName("[VIEW][GET] 해시태그로 조회하는 게시글 뷰를 GET METHOD TEST")
    @Test()
    public void givenHashTag_whenRequestArticlesByHashTag_thenResponseArticlesView() throws Exception {
        // given

        // when
        mock.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("search-hashtag"));

        // then
    }


}