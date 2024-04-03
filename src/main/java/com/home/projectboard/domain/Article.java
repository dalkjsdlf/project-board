package com.home.projectboard.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag")
})
@Entity()
@Getter()
public class Article extends AuditingFields{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Setter()
    @Column(length=255,nullable = false)
    private String title;

    @Setter()
    @Column(length=5000,nullable = true)
    private String content;

    @Setter()
    @Column(length=100,nullable = true)
    private String hashtag;

    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    Set<ArticleComments> articleCommentsSet = new LinkedHashSet<ArticleComments>();

    protected Article() {}

    private Article(String title, String content, String hashTag, Set<ArticleComments> articleCommentsSet) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
        this.articleCommentsSet = articleCommentsSet;
    }

    public static Article of(String title, String content, String hashTag, Set<ArticleComments> articleCommentsSet){
        return new Article(title, content, hashTag, articleCommentsSet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return id != null ||  Objects.equals(id, article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
