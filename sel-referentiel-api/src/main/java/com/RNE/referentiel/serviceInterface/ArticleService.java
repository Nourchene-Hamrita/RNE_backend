package com.RNE.referentiel.serviceInterface;

import java.util.List;

import com.RNE.referentiel.dto.ArticleDTO;

public interface ArticleService {

    public ArticleDTO saveArticle(ArticleDTO articleDTO);

    public ArticleDTO getArticleByCode(String articleCode);

    public List<ArticleDTO> getAllArticles();

    public ArticleDTO updateArticle(String articleCode, ArticleDTO articleDTO);

    public void deleteArticle(String articleCode);

}