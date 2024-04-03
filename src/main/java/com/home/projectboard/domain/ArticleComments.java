package com.home.projectboard.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.Objects;

@ToString
@Getter()
@Table()
@Entity()
public class ArticleComments extends AuditingFields{

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column() Long id;


    @Column(nullable = true, length = 1000)
    private String content;

    @ManyToOne(optional = true)
    private Article article;

    protected ArticleComments() {}

    private ArticleComments(String content, Article article) {
        this.content = content;
        this.article = article;
    }

    public static ArticleComments of(String comments, Article article){
        return new ArticleComments(comments, article);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleComments that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
