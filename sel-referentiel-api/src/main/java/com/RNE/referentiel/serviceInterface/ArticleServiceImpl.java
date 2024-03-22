package com.RNE.referentiel.serviceInterface;

import java.util.List;

import com.RNE.referentiel.entities.Article;



public interface ArticleServiceImpl {
	
	public Article saveArticle(Article article);
	public Article articleById(String codeArticle);
	public List<Article>getAllArticle();
	public Article  updateArticle(String codeArticle,Article article);
	
	public void   deleteArticle(String codeArticle);

}
