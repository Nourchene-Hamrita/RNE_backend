package com.RNE.referentiel.serviceInterface;

import java.util.List;

import com.RNE.referentiel.dto.ArticleDTO;
import com.RNE.referentiel.entities.Article;



public interface ArticleService {
	
	public Article saveArticle(Article article);
	public ArticleDTO articleById(String articleCode);
	public List<ArticleDTO>getAllArticle();
	public Article  updateArticle(String articleCode,Article article);
	
	public void   deleteArticle(String articleCode);

}
