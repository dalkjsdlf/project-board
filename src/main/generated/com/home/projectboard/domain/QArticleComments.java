package com.home.projectboard.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArticleComments is a Querydsl query type for ArticleComments
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArticleComments extends EntityPathBase<ArticleComments> {

    private static final long serialVersionUID = -1627529313L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArticleComments articleComments = new QArticleComments("articleComments");

    public final QAuditingFields _super = new QAuditingFields(this);

    public final QArticle article;

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public QArticleComments(String variable) {
        this(ArticleComments.class, forVariable(variable), INITS);
    }

    public QArticleComments(Path<? extends ArticleComments> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArticleComments(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArticleComments(PathMetadata metadata, PathInits inits) {
        this(ArticleComments.class, metadata, inits);
    }

    public QArticleComments(Class<? extends ArticleComments> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.article = inits.isInitialized("article") ? new QArticle(forProperty("article")) : null;
    }

}

