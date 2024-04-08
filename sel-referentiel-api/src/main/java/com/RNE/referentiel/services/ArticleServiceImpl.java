package com.RNE.referentiel.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.dto.ArticleDTO;
import com.RNE.referentiel.entities.Article;

import com.RNE.referentiel.repositories.ArticleRepository;
import com.RNE.referentiel.services.impl.ArticleService;

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
    public ArticleDTO getArticleByCode(String code) {
        Optional<Article> existArticle = articleRepository.findById(code);
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
    public ArticleDTO updateArticle(String code, ArticleDTO articleDTO) {
        Article existArticle = articleRepository.findById(code).orElse(null);
        if (existArticle == null) {
            return null;
        }

        existArticle.setTitleFr(articleDTO.getTitleFr());
        existArticle.setTitleAr(articleDTO.getTitleAr());
        

        return convertEntityToDto(articleRepository.save(existArticle));
    }

    @Override
    public void deleteArticle(String code) {
        articleRepository.deleteById(code);
    }

    public Article convertDtoToEntity(ArticleDTO articleDTO) {

        Article article = new Article();
        article.setCode(articleDTO.getCode());
        article.setTitleFr(articleDTO.getTitleFr());
        article.setTitleAr(articleDTO.getTitleAr());

        return article;
    }

    public ArticleDTO convertEntityToDto(Article article) {

        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setCode(article.getCode());
        articleDTO.setTitleFr(article.getTitleFr());
        articleDTO.setTitleAr(article.getTitleAr());

        return articleDTO;
    }

}