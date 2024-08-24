package com.RNE.referentiel.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.RNE.referentiel.dto.ArticleDTO;

public interface ArticleService {

    public ArticleDTO saveArticle(ArticleDTO articleDTO);

    public ArticleDTO getArticleByCode(String code);

    public List<ArticleDTO> getAllArticles();

    public ArticleDTO updateArticle(String code, ArticleDTO articleDTO);

    public void deleteArticle(String code);

	public Page<ArticleDTO> getArticlePagination(int pageNumber, int pageSize);

}