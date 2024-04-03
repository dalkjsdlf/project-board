package com.home.projectboard.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;


@Value
public class ArticleDto implements Serializable {
    String title;
    String content;
    String hashtag;
    LocalDateTime createdAt;
    String createdBy;

    public static ArticleDto of(String title, String content, String hashtag){
        return new ArticleDto(title, content, hashtag, LocalDateTime.now(), "dorris");
    }

}