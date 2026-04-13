package com.example.spring_boot_app.controller;

import com.example.spring_boot_app.converter.EntityToDtoConverter;
import com.example.spring_boot_app.dto.ArticleDTO;
import com.example.spring_boot_app.entity.Article;
import com.example.spring_boot_app.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ArticleController {

    Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @PostMapping(value = "/posts")
    public ArticleDTO createArticle(@RequestBody ArticleDTO articleDTO) {
        logger.info("Create article");
        Article article = new Article();
        BeanUtils.copyProperties(articleDTO, article, "id");
        articleService.saveArticle(article);
        articleDTO.setId(article.getId());
        logger.info("Article created");
        return articleDTO;
    }

    @GetMapping(value = "/posts")
    public List<ArticleDTO> getAllArticles() {

        List<Article> articles = articleService.getAllArticles();
        List<ArticleDTO> articleDTOs;
        articleDTOs = articles.stream().map(
                item -> {
                    ArticleDTO articleDTO = new ArticleDTO();
                    EntityToDtoConverter.convertEntityToDto(item, articleDTO);
                    return articleDTO;
                }
        ).toList();
        return articleDTOs;
    }

    @DeleteMapping(value = "/posts/{id}")
    public void deleteArticle(@PathVariable Long id) {
        logger.info("Delete article with id: {}", id);
        articleService.deleteArticle(id);
        logger.info("Article deleted");
    }

}
