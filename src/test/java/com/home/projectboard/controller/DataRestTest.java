package com.home.projectboard.controller;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc()
@SpringBootTest()
@Transactional()
@DisplayName("Data Rest Test")
public class DataRestTest {

    private final MockMvc mockMvc;

    public DataRestTest(
            @Autowired MockMvc mockMvc
    ){
        this.mockMvc = mockMvc;
    }
    @DisplayName("[API TEST WITH DATA REST] Article all find")
    @Test()
    public void givenNothing_whenGetArticles_thenReturnAllArticles() throws Exception{
        // given

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> API TEST 시작");
        // when
        mockMvc.perform(get("/api/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
                .andDo(print());

        // then
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> API TEST 끝");
    }

    @DisplayName("[API TEST WITH DATA REST] Article find by id")
    @Test()
    public void givenNothing_whenGetArticleById_thenReturnArticleById() throws Exception{
        // given

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> API TEST find by Id 시작");
        // when
        mockMvc.perform(get("/api/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
                .andDo(print());

        // then
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> API TEST find by Id 끝");
    }
}
