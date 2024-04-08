package com.RNE.referentiel.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.dto.ArticleDTO;
import com.RNE.referentiel.entities.Article;

import com.RNE.referentiel.repositories.ArticleRepository;

import com.RNE.referentiel.serviceInterface.ArticleService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    // save article service
    @Override
    public ArticleDTO saveArticle(ArticleDTO articleDTO) {

        Article article = convertDtoToEntity(articleDTO);
        return convertEntityToDto(articleRepository.save(article));
    }

    // get article by code service
    @Override
    public ArticleDTO getArticleByCode(String articleCode) {
        Optional<Article> existArticle = articleRepository.findById(articleCode);
        return existArticle.map(this::convertEntityToDto).orElse(null);
    }

    // get all articles services
    @Override
    public List<ArticleDTO> getAllArticles() {

        return articleRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    // update article service
    @Override
    public ArticleDTO updateArticle(String articleCode, ArticleDTO articleDTO) {
        Article existArticle = articleRepository.findById(articleCode).orElse(null);
        if (existArticle == null) {
            return null;
        }

        existArticle.setArticleTitleFr(articleDTO.getArticleTitleFr());
        existArticle.setArticleTitleAr(articleDTO.getArticleTitleAr());

        return convertEntityToDto(articleRepository.save(existArticle));
    }

    @Override
    public void deleteArticle(String articleCode) {
        articleRepository.deleteById(articleCode);
    }

    public Article convertDtoToEntity(ArticleDTO articleDTO) {

        Article article = new Article();
        article.setArticleCode(articleDTO.getArticleCode());
        article.setArticleTitleFr(articleDTO.getArticleTitleFr());
        article.setArticleTitleAr(articleDTO.getArticleTitleAr());

        return article;
    }

    public ArticleDTO convertEntityToDto(Article article) {

        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setArticleCode(article.getArticleCode());
        articleDTO.setArticleTitleFr(article.getArticleTitleFr());
        articleDTO.setArticleTitleAr(article.getArticleTitleAr());

        return articleDTO;
    }

}