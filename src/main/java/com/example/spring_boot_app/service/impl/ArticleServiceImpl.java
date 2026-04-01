package com.example.spring_boot_app.service.impl;

import com.example.spring_boot_app.entity.Article;
import com.example.spring_boot_app.repository.ArticleRepository;
import com.example.spring_boot_app.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    @Override
    public Article updateArticle(Long id, Article article) {
        return articleRepository.findById(id).map(existingArticle -> {
            existingArticle.setTitle(article.getTitle());
            existingArticle.setBody(article.getBody());
            existingArticle.setUserId(article.getUserId());
            return articleRepository.save(existingArticle);
        }).orElseThrow(() -> new RuntimeException("Article not found with id " + id));
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
