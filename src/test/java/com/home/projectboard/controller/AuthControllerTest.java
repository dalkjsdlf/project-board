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
@WebMvcTest()
class AuthControllerTest {

    private final MockMvc mock;

    public AuthControllerTest(@Autowired MockMvc mock) {
        this.mock = mock;
    }


    @DisplayName("[VIEW][GET] 로그인 뷰를 GET METHOD TEST")
    @Test()
    public void givenNothing_whenRequestLogin_thenResponseLoginView() throws Exception {
        // given

        // when
        mock
                .perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));

        // then
    }
}