package com.home.projectboard.repository;

import com.home.projectboard.config.JpaConfig;
import com.home.projectboard.domain.Article;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Import(JpaConfig.class)
@DataJpaTest()
@Transactional()
@AutoConfigureTestEntityManager()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ArticleRepositoryTest {

    private final ArticleRepository articleRepository;
    public ArticleRepositoryTest(@Autowired ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @DisplayName("Article findAll 테스트")
    @Test()
    public void givenNothing_whenSelecting_thenNotnull(){
        // given

        // when
        List<Article> articles = articleRepository.findAll();
        // then
        assertThat(articles).isNotNull().hasSize(1000);

        System.out.println("[findAll 테스트] >>>>>>>>" + articles.size());
    }

    @DisplayName("Article findById 테스트")
    @Test()
    public void givenArticleId_whenSelectingOne_thenOneObject(){
        // given
        long articleId = 1L;

        // when
        Optional<Article> article = articleRepository.findById(articleId);

        // then
        assertThat(article).isNotNull();

        System.out.println("[findById 테스트] >>>>>>>>" + article.get().getId());
    }

    @DisplayName("insert test")
    @Test()
    public void givenArticle_whenInserting_thenInsertObject(){
        // given
        Article article = Article.of("직접입력하는테스트1","직접입력하는테스트임11","test",null);

        // when
        Article savedArticle = articleRepository.save(article);

        // then
        assertThat(article).isNotNull().isEqualTo(savedArticle);

        System.out.println("[Insert 테스트] >>>>>>>>" + articleRepository.count());
    }

    @DisplayName("update test")
    @Test()
    public void givenId1item_whenUpdatingTitle_thenCompareUpdateValue(){
        // given
        Optional<Article> article = articleRepository.findById(1L);
        String changeTitle = "changedTitleValue";
        // when
        article.get().setTitle(changeTitle);

        Article updatedArticle = articleRepository.save(article.get());

        // then
        assertThat(updatedArticle.getTitle()).isEqualTo(changeTitle);

        System.out.println("[ updatedTitle ]  >>>>> " + updatedArticle.getTitle());
    }

    @DisplayName("remove article test")
    @Test()
    public void givenId1L_whenDeletingItem_thenCompareCount(){
        // given
        long id = 1L;

        // when
        articleRepository.deleteById(1L);

        List<Article> articles = articleRepository.findAll();

        // then
        assertThat(articles).isNotNull().hasSize(999);

        System.out.println("[delete test ] >>>>> " + articles.size());
    }
}