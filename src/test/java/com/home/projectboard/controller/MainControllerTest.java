package com.home.projectboard.controller;

import com.home.projectboard.config.SecurityConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("게시판 루트 경로 입력시 테스트")
@Import(SecurityConfig.class)
@WebMvcTest(MainController.class)
class MainControllerTest {

    private MockMvc mock;

    public MainControllerTest(@Autowired MockMvc mock) {
        this.mock = mock;
    }

    @DisplayName("루트경로 입력시 articles페이지로 redirect")
    @Test()
    public void given_whenConnectRootPage_thenRedirectArticles() throws Exception {
        // given

        // when
        mock
                .perform(get(""))
                .andExpect(status().is3xxRedirection());

        // then
    }
}