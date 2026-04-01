package com.example.spring_boot_app.service;

import com.example.spring_boot_app.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    Article saveArticle(Article article);
    List<Article> getAllArticles();
    Optional<Article> getArticleById(Long id);
    Article updateArticle(Long id, Article article);
    void deleteArticle(Long id);
}
