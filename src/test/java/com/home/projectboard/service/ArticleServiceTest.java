package com.home.projectboard.service;

import com.home.projectboard.dto.ArticleDto;
import com.home.projectboard.repository.ArticleRepository;
import com.home.projectboard.type.SearchType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("비즈니스 모델 - 게시")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService sut;
    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글을 특정 조건으로[] 검색하면, 게시글들을 검색한다.")
    @Test()
    public void givenSearchCondition_whenSearchArticles_thenGetArticleList(){
        // given
        // 검색타입, 키워드
        // SearchType[제목, 내용, 해시태그]

        // when
        //
        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "This is keyowrd");

        // then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글을 ID로 검색하면, 게시글을 검색한다.")
    @Test()
    public void givenArticleId_whenSearchArticleById_thenGetArticleList(){
        // given
        // 검색타입, 키워드
        // SearchType[제목, 내용, 해시태그]

        // when
        //
        ArticleDto article = sut.searchArticle(1l);

        // then
        assertThat(article).isNotNull();
    }
}