package com.RNE.referentiel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.entities.Article;
import com.RNE.referentiel.repositories.ArticleRepository;
import com.RNE.referentiel.serviceInterface.ArticleService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArticleImpl implements ArticleService{
	
private ArticleRepository articleRepository;

@Override
public Article saveArticle(Article article) {
	// TODO Auto-generated method stub
	return articleRepository.save(article);}


@Override
public List<Article> getAllArticle() {
	// TODO Auto-generated method stub
	return articleRepository.findAll();
}

@Override
public Article updateArticle(String articleCode, Article article) {
	// TODO Auto-generated method stub
	Article	existArticle=articleRepository.findById(articleCode).orElse(null);
	 existArticle.setArticleCode(article.getArticleCode());
	 existArticle.setArticleTitleFr(article.getArticleTitleFr());
	 existArticle.setArticleTitleAr(article.getArticleTitleAr());
	 existArticle.setActivation(article.getActivation());
	 existArticle.setProposal(article.getProposal());
	 
	return articleRepository.save(existArticle);
}

@Override
public void deleteArticle(String articleCode) {
	
	articleRepository.deleteById(articleCode);
	// TODO Auto-generated method stub
	
}

@Override
public Article articleById(String articleCode) {
	// TODO Auto-generated method stub
	Article	existArticle=articleRepository.findById(articleCode).orElse(null);
	return existArticle;
}

}
