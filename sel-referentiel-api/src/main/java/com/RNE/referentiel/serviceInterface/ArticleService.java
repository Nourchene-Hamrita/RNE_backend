package com.RNE.referentiel.serviceInterface;

import java.util.List;

import com.RNE.referentiel.entities.Article;



public interface ArticleService {
	
	public Article saveArticle(Article article);
	public Article articleById(String articleCode);
	public List<Article>getAllArticle();
	public Article  updateArticle(String articleCode,Article article);
	
	public void   deleteArticle(String articleCode);

}
