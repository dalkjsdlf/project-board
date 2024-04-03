package com.home.projectboard.service;

import com.home.projectboard.dto.ArticleDto;
import com.home.projectboard.repository.ArticleRepository;
import com.home.projectboard.type.SearchType;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ArticleService {

    private ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String keyword){
        return Page.empty();
    }

    public ArticleDto searchArticle(long articleId){
        return ArticleDto.of("title","content","hashtag");

    }
}
